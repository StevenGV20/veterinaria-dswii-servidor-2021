package com.veterinaria.servidor.service;

import java.util.List;

import com.veterinaria.servidor.entity.Categoria;
import com.veterinaria.servidor.entity.Distrito;

public interface ComboService {

	public abstract List<Distrito> listaDistrito();
	public abstract List<Categoria> listaCategoria();
	
	
}
