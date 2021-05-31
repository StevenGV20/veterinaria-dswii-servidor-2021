package com.veterinaria.servidor.service;
import java.util.List;
import java.util.Optional;

import com.veterinaria.servidor.entity.Incidencia2;

public interface Incidencia2Service {

	//DISTRITO
	//public abstract List<Distrito> listaDistrito();
	
	public abstract Incidencia2 registrarIncidencia(Incidencia2 obj);
	public abstract List<Incidencia2> listaIncidencia2();
	public abstract Incidencia2 ultimoIncidencia2Registrado();
	public abstract Optional<Incidencia2> buscaIncidencia2PorId(int idincidencia);
	public abstract void eliminaIncidencia2(int idincidencia);
	//public abstract Usuario ultimoClienteRegistrado();
	
	/*public abstract Usuario buscarUsuarioByID(int id);
	public abstract void eliminaUsuario(int id);*/
	//public abstract List<Usuario> listaCliente();

}
