package com.veterinaria.servidor.service;

import java.util.List;
import java.util.Optional;

import com.veterinaria.servidor.entity.Opcion;
import com.veterinaria.servidor.entity.Rol;
import com.veterinaria.servidor.entity.Usuario;

public interface UsuarioService {
	
	//DISTRITO
	//public abstract List<Distrito> listaDistrito();
	
	//ROL
	public abstract List<Rol> listaRol();
	
	//USUARIO
	public abstract List<Usuario> listaUsuario();
	public abstract List<Usuario> listaPersonalTrabajo();
	public abstract Usuario registraUsuario(Usuario bean);
	public abstract Optional<Usuario> buscaUsuarioPorId(Integer idusuario);
	public abstract Usuario buscaUsuarioPorCorreo(String correo);
	public abstract Usuario buscarUsuarioXRol(int idusuario);
	public abstract void eliminaUsuario(int idusuario);
	public abstract List<Usuario> listaUsuarioPorRol(int idrol);
	
	public abstract Usuario login(Usuario bean);
	public abstract List<Usuario> verificarRegistro(Usuario bean);

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);
	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	
	
	
	
	
	
}
