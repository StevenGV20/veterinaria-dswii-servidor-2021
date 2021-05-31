package com.veterinaria.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.servidor.entity.Categoria;
import com.veterinaria.servidor.entity.Distrito;
import com.veterinaria.servidor.repository.CategoriaRepository;
import com.veterinaria.servidor.repository.DistritoRepository;

@Service
public class ComboServiceImpl implements ComboService{

	
	@Autowired
	private DistritoRepository distritoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Distrito> listaDistrito() {
		return distritoRepository.findAll();
	}

	@Override
	public List<Categoria> listaCategoria() {
		return categoriaRepository.findAll();
	}

}
