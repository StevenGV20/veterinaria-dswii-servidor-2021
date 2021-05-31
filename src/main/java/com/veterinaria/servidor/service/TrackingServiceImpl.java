package com.veterinaria.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.servidor.entity.DetallePedidoUsuario;
import com.veterinaria.servidor.entity.DetallePedidoUsuarioPK;
import com.veterinaria.servidor.entity.Tracking;
import com.veterinaria.servidor.entity.Usuario;
import com.veterinaria.servidor.repository.DetallePedidoUsuarioRepository;
import com.veterinaria.servidor.repository.PedidoRepository;
import com.veterinaria.servidor.repository.TrackingRepository;

@Service
public class TrackingServiceImpl implements TrackingService{

	@Autowired
	private TrackingRepository repository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private DetallePedidoUsuarioRepository historialrepository;
	
	@Override
	public Tracking registraTracking(Tracking bean) {
		return repository.save(bean);
	}

	@Override
	public Tracking modificaTracking(Tracking bean) {
		return null;
	}

	@Override
	public Optional<Tracking> buscaTrackinById(int cod) {
		return repository.findById(cod);
	}

	@Override
	public Optional<Tracking> buscaTrackinByPedido(int cod) {
		return repository.buscaTrackingByPedido(cod);
	}

	@Override
	public List<DetallePedidoUsuario> buscarHistorialPedido(int cod) {
		return historialrepository.buscaHistorialPedidoById(cod);
	}

	@Override
	public List<Tracking> listaAllTracking() {
		return repository.findAll();
	}

	@Override
	public List<Tracking> listaTrackingByCliente(int id) {
		return repository.buscaTrackingByCliente(id);
	}

	@Override
	public List<Tracking> listaTrackingByTrabajador(int id) {
		return repository.buscaTrackingByTrabajador(id);
	}

	@Override
	public Tracking asignaTrabajador(Tracking bean,Usuario usu) {
		bean.setEstado("EN CAMINO");
		//bean.getPedido().setEstado("EN CAMINO");
		//int id=bean.getPedido().getIdpedido();
		//Pedido ped=pedidoRepository.actualizaEstadoPedido("EN CAMINO", id);
		Tracking obj=repository.save(bean);		
		DetallePedidoUsuario historia=new DetallePedidoUsuario();
		DetallePedidoUsuarioPK dupk=new DetallePedidoUsuarioPK();
		dupk.setIdpedido(obj.getPedido().getIdpedido());
		dupk.setIdusuario(usu.getIdusuario());
		historia.setEstado("APROBADO Y EN CAMINO");
		//historia.setPedido(obj.getPedido());
		//historia.setUsuario(obj.getTrabajador());
		historia.setDetallePK(dupk);
		historialrepository.save(historia);
		return obj;
	}

	@Override
	public Tracking registrarEntrega(Tracking bean) {
		//Tracking obj=repository.registrarEntrega(bean.getFechaEntrega(),bean.getHoraEntrega(),bean.getEstado(),bean.getIdtracking());
		Tracking obj=repository.save(bean);
		DetallePedidoUsuario historia=new DetallePedidoUsuario();
		
		DetallePedidoUsuarioPK dupk=new DetallePedidoUsuarioPK();
		dupk.setIdpedido(obj.getPedido().getIdpedido());
		dupk.setIdusuario(obj.getTrabajador().getIdusuario());
		
		historia.setEstado(obj.getEstado());
		historia.setFechaModificacion(obj.getFechaEntrega());
		historia.setDetallePK(dupk);
		historialrepository.save(historia);
		return obj;
	}

}
