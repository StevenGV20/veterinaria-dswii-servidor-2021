package com.veterinaria.servidor.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.veterinaria.servidor.entity.Categoria;
import com.veterinaria.servidor.entity.Producto;

public interface ProductoService {
	
	//CATEGORIA
	public abstract List<Categoria> listaCategeoria();
	
	//PRODUCTO
	public abstract List<Producto> listaProducto();
	public abstract Producto mantenerProducto(Producto bean);
	public abstract Optional<Producto> buscaProductoPorId(int idproducto);
	public abstract void eliminaProducto(int idproducto);
	public abstract Producto detalleProductoXID(int idproducto);
	
	//CONSULTAS
	public abstract List<Producto> listaProductoByNombre(String nombre);
	public abstract List<Producto> listaProductoByNombreAaZ();
	public abstract List<Producto> listaProductoByNombreZaA();
	public abstract List<Producto> listaProductoByPrecioMenorMayor();
	public abstract List<Producto> listaProductoByPrecioMayoraMenor();
	
	//SUBIR ARCHIVOS
	public abstract void saveFile(MultipartFile file) throws Exception;
	
	public abstract void saveFotos(List<MultipartFile> files) throws IOException;
	
}
