package com.veterinaria.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.servidor.entity.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Integer>{

}
