package com.veterinaria.servidor.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.servidor.entity.Tracking;

public interface TrackingRepository extends JpaRepository<Tracking, Integer>{
	
	@Query("Select t from Tracking t where t.pedido.idpedido = :cod")
	public Optional<Tracking> buscaTrackingByPedido(@Param("cod") int cod);
	
	@Query("Select t from Tracking t where t.pedido.cliente.idusuario = :cod")
	public List<Tracking> buscaTrackingByCliente(@Param("cod") int cod);
	

	@Query("Select t from Tracking t where t.trabajador.idusuario = :cod")
	public List<Tracking> buscaTrackingByTrabajador(@Param("cod") int cod);
	
	@Modifying
	@Query("update Tracking t set t.fechaEntrega = :fecha, t.horaEntrega = :hora, t.estado = :estado where t.idtracking = :id")
	public abstract Tracking registrarEntrega(@Param("fecha")Date fecha,@Param("hora")Date hora,@Param("estado")String estado,@Param("id")int id);
	 
}
