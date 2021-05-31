package com.veterinaria.servidor.service;
import java.util.List;
import java.util.Optional;

import com.veterinaria.servidor.entity.Consulta2;

public interface Consulta2Service {

	//DISTRITO
	//public abstract List<Distrito> listaDistrito();
	
	public abstract Consulta2 registrarConsulta(Consulta2 obj);
	public abstract List<Consulta2> listaConsulta2();
	public abstract Consulta2 ultimoConsulta2Registrado();
	public abstract Optional<Consulta2> buscaConsulta2PorId(int idconsulta);
	public abstract void eliminaConsulta2(int idconsulta);
	//public abstract Usuario ultimoClienteRegistrado();
	
	/*public abstract Usuario buscarUsuarioByID(int id);
	public abstract void eliminaUsuario(int id);*/
	//public abstract List<Usuario> listaCliente();

}
