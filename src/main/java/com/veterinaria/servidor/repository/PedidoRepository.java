package com.veterinaria.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.servidor.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Query("Select p from Pedido p where p.cliente.idusuario = :usu")
	public abstract List<Pedido> listaPedidoByCliente(@Param("usu")int usu);
/*
	@Query("Select p from Pedido p where p.estado = :estado")
	public abstract List<Pedido> listaPedidoByEstado(@Param("estado")String estado);
	*/
	/*
	@Modifying
	@Query("update Pedido p set p.estado = :estado where p.idpedido = :id")
	public abstract Pedido actualizaEstadoPedido(@Param(value = "estado")String estado,@Param(value="id")int id);
	*/
	
	@Query("Select p from Pedido p, DetallePedido d, Producto po, Usuario u "
			+ "where p.idpedido = d.pedido.idpedido and "
			+ "d.producto.idproducto = po.idproducto and "
			+ "p.cliente.idusuario = u.idusuario and "
			+ "p.idpedido = :cod")
	//@Query(value = "SELECT * FROM pedido p where p.idpedido = :cod",nativeQuery = true)
	public abstract List<Pedido> listaDetallePedidoByCod(@Param("cod")int cod);
}
