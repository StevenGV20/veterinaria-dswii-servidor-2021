package com.veterinaria.servidor.service;
import java.util.List;

import com.veterinaria.servidor.entity.Distrito;
import com.veterinaria.servidor.entity.Usuario;

public interface ClienteService {

	//DISTRITO
	public abstract List<Distrito> listaDistrito();
	
	public abstract Usuario registrarCiente(Usuario bean);
	public abstract Usuario ultimoClienteRegistrado();
	
	/*public abstract Usuario buscarUsuarioByID(int id);
	public abstract void eliminaUsuario(int id);*/
	public abstract List<Usuario> listaCliente();

}
