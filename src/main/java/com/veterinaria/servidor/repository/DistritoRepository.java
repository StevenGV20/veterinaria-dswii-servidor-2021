package com.veterinaria.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.servidor.entity.Distrito;

public interface DistritoRepository extends JpaRepository<Distrito, Integer> {
	
}
