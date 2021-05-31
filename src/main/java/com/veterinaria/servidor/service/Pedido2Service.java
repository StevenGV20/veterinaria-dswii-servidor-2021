package com.veterinaria.servidor.service;
import java.util.List;
import java.util.Optional;

import com.veterinaria.servidor.entity.Pedido2;

public interface Pedido2Service {

	//DISTRITO
	//public abstract List<Distrito> listaDistrito();
	
	public abstract Pedido2 registrarPedido(Pedido2 obj);
	public abstract List<Pedido2> listaPedido2();
	public abstract Pedido2 ultimoPedido2Registrado();
	public abstract Optional<Pedido2> buscaPedido2PorId(int idpedido);
	public abstract void eliminaPedido2(int idpedido);
	//public abstract Usuario ultimoClienteRegistrado();
	
	/*public abstract Usuario buscarUsuarioByID(int id);
	public abstract void eliminaUsuario(int id);*/
	//public abstract List<Usuario> listaCliente();

}
