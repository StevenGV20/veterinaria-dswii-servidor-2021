package com.veterinaria.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.servidor.entity.Pedido2;
import com.veterinaria.servidor.entity.Rol;
import com.veterinaria.servidor.repository.Pedido2Repository;

@Service
public class Pedido2ServiceImpl implements Pedido2Service {

	@Autowired
	private Pedido2Repository repository;
	/*
	@Autowired 
	private DistritoRepository disrepository;*/
	/*	
	@Override
	public List<Distrito> listaDistrito() {
		return disrepository.findAll();
	}*/
	
	@Override
	public Pedido2 registrarPedido(Pedido2 obj) {
		Rol objRol = new Rol();
		objRol.setIdrol(1);
		obj.setIdrol(objRol);
		return repository.save(obj);
	}
	
	@Override
	public List<Pedido2> listaPedido2() {
		return repository.listaPedido2();
	}
	
	@Override
	public Pedido2 ultimoPedido2Registrado() {
		return repository.listarUltimoPedido2Registrado().orElse(null);
	}
	
	@Override
	public Optional<Pedido2> buscaPedido2PorId(int idpedido) {
		
		return repository.findById(idpedido);
	}
	
	@Override
	public void eliminaPedido2(int idpedido) {
		repository.deleteById(idpedido);
		
	}
/*
	@Override
	public Usuario ultimoClienteRegistrado() {
		return repository.listarUltimoUsuarioRegistrado().orElse(null);
	}

	@Override
	public List<Usuario> listaCliente() {
		return repository.listaClientes();
	}*/

	
}
