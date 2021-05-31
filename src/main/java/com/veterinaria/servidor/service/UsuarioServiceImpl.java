package com.veterinaria.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.servidor.entity.Opcion;
import com.veterinaria.servidor.entity.Rol;
import com.veterinaria.servidor.entity.Usuario;
import com.veterinaria.servidor.repository.RolRepository;
import com.veterinaria.servidor.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private RolRepository rolrepository;
	
	@Override
	public List<Usuario> listaUsuarioPorRol(int idrol) {
		return repository.listaUsuarioByRol(idrol);
	}
/*
	@Override
	public Trabajador mantenerTrabajador(Trabajador bean) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	@Override
	public List<Rol> listaRol() {
		return rolrepository.findAll();
	}

	@Override
	public List<Usuario> listaUsuario() {
		
		return repository.findAll();
	}

	@Override
	public Usuario registraUsuario(Usuario bean) {
		return repository.save(bean);
	}

	@Override
	public Optional<Usuario> buscaUsuarioPorId(int idusuario) {
		
		return repository.findById(idusuario);
	}

	@Override
	public void eliminaUsuario(int idusuario) {
		repository.deleteById(idusuario);
		
	}

	@Override
	public Usuario buscarUsuarioXRol(int idusuario) {
		
		return repository.findById(idusuario).orElse(null);
	}

	@Override
	public Usuario login(Usuario bean) {
		return repository.login(bean);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		return null;
	}

	@Override
	public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
		return repository.traerEnlacesDeUsuario(idUsuario);
	}

	@Override
	public List<Usuario> verificarRegistro(Usuario bean) {
		return repository.verificarRegistro(bean);
	}

	@Override
	public List<Usuario> listaPersonalTrabajo() {
		return repository.listaPersonalTrabajo();
	}



}
