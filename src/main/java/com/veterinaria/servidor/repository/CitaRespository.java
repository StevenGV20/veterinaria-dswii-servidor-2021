package com.veterinaria.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.servidor.entity.Cita;

@Repository
public interface CitaRespository extends JpaRepository<Cita, Integer>{
	@Query("Select c from Cita c where c.cliente.idusuario = :usu")
	public abstract List<Cita> listaCitaByCliente(@Param("usu")int usu);
	
	@Query("Select c from Cita c where c.veterinario.idusuario = :usu")
	public abstract List<Cita> listaCitaByVeterinario(@Param("usu")int usu);
}
