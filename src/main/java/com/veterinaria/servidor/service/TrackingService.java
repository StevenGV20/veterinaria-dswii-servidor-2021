package com.veterinaria.servidor.service;

import java.util.List;
import java.util.Optional;

import com.veterinaria.servidor.entity.DetallePedidoUsuario;
import com.veterinaria.servidor.entity.Tracking;
import com.veterinaria.servidor.entity.Usuario;

public interface TrackingService {
	
	public abstract Tracking registraTracking(Tracking bean);
	public abstract Tracking registrarEntrega(Tracking bean);
	public abstract Tracking modificaTracking(Tracking bean);
	public abstract Tracking asignaTrabajador(Tracking bean,Usuario usu);
	public abstract List<Tracking> listaAllTracking();
	public abstract List<Tracking> listaTrackingByCliente(int id);
	public abstract List<Tracking> listaTrackingByTrabajador(int id);
	public abstract Optional<Tracking> buscaTrackinById(int cod);
	public abstract Optional<Tracking> buscaTrackinByPedido(int cod);
	public abstract List<DetallePedidoUsuario> buscarHistorialPedido(int cod);
	
	
}
