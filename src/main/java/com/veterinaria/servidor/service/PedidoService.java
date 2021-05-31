package com.veterinaria.servidor.service;

import java.util.List;
import java.util.Optional;

import com.veterinaria.servidor.entity.DetallePedido;
import com.veterinaria.servidor.entity.Pedido;
import com.veterinaria.servidor.entity.Seleccion;

public interface PedidoService {
	public abstract Pedido registraPedido(Pedido bean,List<DetallePedido> detalle);
	public abstract Optional<Pedido> buscaPedidoById(int cod);
	public abstract List<Pedido> listaPedido();
	public abstract List<Pedido> listaPedidoByCliente(int usu);
	public abstract List<Pedido> listaPedidoByEstado(String estado);
	public abstract Pedido updateEstadoPedido(Pedido bean);
	public abstract List<DetallePedido> buscaDetallePedidoById(int id);
	public abstract List<Pedido> listaDetallePedidoByCod(int id);
	public abstract List<Seleccion> buscaBoletaxid(int id);
}
