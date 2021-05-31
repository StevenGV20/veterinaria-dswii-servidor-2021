package com.veterinaria.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.servidor.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer>{
	@Query("Select m from Mascota m where m.cliente.idusuario = :cod_cli")
	public abstract List<Mascota> listaMascotaByCliente(@Param("cod_cli") int cod_cli);
}
