package com.veterinaria.servidor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.veterinaria.servidor.entity.Incidencia2;

public interface Incidencia2Repository extends JpaRepository<Incidencia2, Integer> {
	
	//@Query("select distinct x.nombre from Consulta2 x")
	@Query("Select c from Incidencia2 c where c.idrol.idrol = 1")
	public abstract List<Incidencia2> listaIncidencia2();
	
	@Query(value = "SELECT * FROM Incidencia2 order by idincidencia desc limit 1",nativeQuery = true)
	public abstract Optional<Incidencia2> listarUltimoIncidencia2Registrado();

}
