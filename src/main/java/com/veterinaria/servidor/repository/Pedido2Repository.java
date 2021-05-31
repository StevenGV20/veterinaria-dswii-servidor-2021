package com.veterinaria.servidor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.veterinaria.servidor.entity.Pedido2;

public interface Pedido2Repository extends JpaRepository<Pedido2, Integer> {
	
	//@Query("select distinct x.nombre from Consulta2 x")
	@Query("Select c from Pedido2 c where c.idrol.idrol = 1")
	public abstract List<Pedido2> listaPedido2();
	
	@Query(value = "SELECT * FROM Pedido2 order by idpedido desc limit 1",nativeQuery = true)
	public abstract Optional<Pedido2> listarUltimoPedido2Registrado();

}
