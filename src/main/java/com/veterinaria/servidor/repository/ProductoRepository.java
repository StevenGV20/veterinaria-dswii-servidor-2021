package com.veterinaria.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.servidor.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	@Query("Select p from Producto p where p.nombre like :nombre")
	public abstract List<Producto> listaProductoByName(@Param("nombre") String nombre);
	
	@Query("Select p from Producto p order by p.nombre asc")
	public abstract List<Producto> listaProductoByNameAaZ();
	
	@Query("Select p from Producto p order by p.nombre desc")
	public abstract List<Producto> listaProductoByNameZaA();

	@Query("Select p from Producto p order by p.precio desc")
	public abstract List<Producto> listaProductoByPrecioMayor();

	@Query("Select p from Producto p order by p.precio asc")
	public abstract List<Producto> listaProductoByPrecioMenor();
	
}
