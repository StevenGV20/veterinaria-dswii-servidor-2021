package com.veterinaria.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.servidor.entity.Distrito;
import com.veterinaria.servidor.entity.Rol;
import com.veterinaria.servidor.entity.Usuario;
import com.veterinaria.servidor.repository.ClienteRepository;
import com.veterinaria.servidor.repository.DistritoRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired 
	private DistritoRepository disrepository;
		
	@Override
	public List<Distrito> listaDistrito() {
		return disrepository.findAll();
	}
	
	@Override
	public Usuario registrarCiente(Usuario bean) {
		Rol objRol = new Rol();
		objRol.setIdrol(1);
		bean.setIdrol(objRol);
		return repository.save(bean);
	}

	@Override
	public Usuario ultimoClienteRegistrado() {
		return repository.listarUltimoUsuarioRegistrado().orElse(null);
	}

	@Override
	public List<Usuario> listaCliente() {
		return repository.listaClientes();
	}
	
}
