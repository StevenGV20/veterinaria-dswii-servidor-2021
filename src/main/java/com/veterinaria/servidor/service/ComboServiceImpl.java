package com.veterinaria.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.servidor.entity.Categoria;
import com.veterinaria.servidor.entity.Distrito;
import com.veterinaria.servidor.entity.Especie;
import com.veterinaria.servidor.entity.Rol;
import com.veterinaria.servidor.repository.CategoriaRepository;
import com.veterinaria.servidor.repository.DistritoRepository;
import com.veterinaria.servidor.repository.EspecieRepository;
import com.veterinaria.servidor.repository.RolRepository;

@Service
public class ComboServiceImpl implements ComboService{

	
	@Autowired
	private DistritoRepository distritoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private EspecieRepository especieRepository;
	
	@Override
	public List<Distrito> listaDistrito() {
		return distritoRepository.findAll();
	}

	@Override
	public List<Categoria> listaCategoria() {
		return categoriaRepository.findAll();
	}

	@Override
	public List<Rol> listaRol() {
		return rolRepository.findAll();
	}

	@Override
	public List<Especie> listaEspecie() {
		return especieRepository.findAll();
	}

}
