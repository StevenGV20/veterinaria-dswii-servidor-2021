package com.veterinaria.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.servidor.entity.DetallePedido;
import com.veterinaria.servidor.entity.Seleccion;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer>{

	@Modifying
	@Query("update Producto p set p.stock = p.stock - :can where p.idproducto = :pro")
	public abstract void actualizaStock(@Param("can")int cantidad,@Param("pro")int idproducto);
	
	@Query("Select d from Pedido p, DetallePedido d, Producto po "
			+ "where p.idpedido = d.pedido.idpedido and "
			+ "d.producto.idproducto = po.idproducto and "
			+ "p.idpedido = :id")
	/*@Query("Select d from DetallePedido d join Pedido p on d.pedido.idpedido=p.idpedido"
			+ "where p.idpedido = :id")*/
	public abstract List<DetallePedido> buscaDetallePedidoById(@Param("id")int id);
	
	@Query(value = "select*from detalle_pedido_productos where idpedido = :id",nativeQuery = true)
	public abstract List<Seleccion> buscaBoletaById(@Param("id")int id); 
}
