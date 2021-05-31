package com.veterinaria.servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.servidor.entity.Consulta2;
import com.veterinaria.servidor.entity.Rol;
import com.veterinaria.servidor.repository.Consulta2Repository;

@Service
public class Consulta2ServiceImpl implements Consulta2Service {

	@Autowired
	private Consulta2Repository repository;
	/*
	@Autowired 
	private DistritoRepository disrepository;*/
	/*	
	@Override
	public List<Distrito> listaDistrito() {
		return disrepository.findAll();
	}*/
	
	@Override
	public Consulta2 registrarConsulta(Consulta2 obj) {
		Rol objRol = new Rol();
		objRol.setIdrol(1);
		obj.setIdrol(objRol);
		return repository.save(obj);
	}
	
	@Override
	public List<Consulta2> listaConsulta2() {
		return repository.listaConsulta2();
	}
	
	@Override
	public Consulta2 ultimoConsulta2Registrado() {
		return repository.listarUltimoConsulta2Registrado().orElse(null);
	}
	
	@Override
	public Optional<Consulta2> buscaConsulta2PorId(int idconsulta) {
		
		return repository.findById(idconsulta);
	}
	
	@Override
	public void eliminaConsulta2(int idconsulta) {
		repository.deleteById(idconsulta);
		
	}
/*
	@Override
	public Usuario ultimoClienteRegistrado() {
		return repository.listarUltimoUsuarioRegistrado().orElse(null);
	}

	@Override
	public List<Usuario> listaCliente() {
		return repository.listaClientes();
	}*/

	
}
