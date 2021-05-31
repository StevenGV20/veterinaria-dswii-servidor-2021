package com.veterinaria.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.servidor.entity.DetallePedidoUsuario;

public interface DetallePedidoUsuarioRepository extends JpaRepository<DetallePedidoUsuario, Integer>{
	@Query("Select d from Pedido p, DetallePedidoUsuario d, Usuario u "
			+ "where p.idpedido = d.pedido.idpedido and "
			+ "d.usuario.idusuario = u.idusuario and "
			+ "p.idpedido = :id")
	public abstract List<DetallePedidoUsuario> buscaHistorialPedidoById(@Param("id")int id);
}
