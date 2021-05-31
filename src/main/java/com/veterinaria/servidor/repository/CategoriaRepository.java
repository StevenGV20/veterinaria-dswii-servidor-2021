package com.veterinaria.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.servidor.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
