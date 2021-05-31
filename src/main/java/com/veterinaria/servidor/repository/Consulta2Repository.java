package com.veterinaria.servidor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.veterinaria.servidor.entity.Consulta2;

public interface Consulta2Repository extends JpaRepository<Consulta2, Integer> {
	
	//@Query("select distinct x.nombre from Consulta2 x")
	@Query("Select c from Consulta2 c where c.idrol.idrol = 1")
	public abstract List<Consulta2> listaConsulta2();
	
	@Query(value = "SELECT * FROM Consulta2 order by idconsulta desc limit 1",nativeQuery = true)
	public abstract Optional<Consulta2> listarUltimoConsulta2Registrado();

}
