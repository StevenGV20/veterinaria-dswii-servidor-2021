package com.veterinaria.servidor.service;

import java.util.List;

import com.veterinaria.servidor.entity.Categoria;
import com.veterinaria.servidor.entity.Distrito;
import com.veterinaria.servidor.entity.Especie;
import com.veterinaria.servidor.entity.Rol;

public interface ComboService {

	public abstract List<Distrito> listaDistrito();
	public abstract List<Categoria> listaCategoria();
	public abstract List<Rol> listaRol();
	public abstract List<Especie> listaEspecie();
	
}
