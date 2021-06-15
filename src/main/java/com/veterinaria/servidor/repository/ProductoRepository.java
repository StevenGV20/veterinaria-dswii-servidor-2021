package com.veterinaria.servidor.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veterinaria.servidor.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	@Query("Select p from Producto p where p.nombre like :nombre")
	public abstract List<Producto> listaProductoByName(@Param("nombre") String nombre);
	
	@Query("Select p from Producto p order by p.nombre asc")
	public abstract Page<Producto> listaProductoByNameAaZ(Pageable pageable);
	
	@Query("Select p from Producto p order by p.nombre desc")
	public abstract Page<Producto> listaProductoByNameZaA(Pageable pageable);

	@Query("Select p from Producto p order by p.precio desc")
	public abstract Page<Producto> listaProductoByPrecioMayor(Pageable pageable);

	@Query("Select p from Producto p order by p.precio asc")
	public abstract Page<Producto> listaProductoByPrecioMenor(Pageable pageable);
	
	@Query("Select p from Producto p")
	public abstract Page<Producto> listaAllProducto(Pageable pageable);
	
	@Modifying
	@Query("update Producto p set p.foto1 = :#{#pro.foto1},p.foto3 = :#{#pro.foto}, p.foto2 = :#{#pro.foto2} "
			+ "where p.idproducto = :#{#pro.idproducto}")
	public abstract Producto actualizaFotos(@Param(value = "pro") Producto pro);
	
}
