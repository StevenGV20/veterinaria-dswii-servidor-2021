package com.veterinaria.servidor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.veterinaria.servidor.entity.Usuario;

public interface ClienteRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "SELECT * FROM usuario order by idusuario desc limit 1",nativeQuery = true)
	public abstract Optional<Usuario> listarUltimoUsuarioRegistrado();
	
	@Query("Select c from Usuario c where c.idrol.idrol = 1")
	public abstract List<Usuario> listaClientes();
}
