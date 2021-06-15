package com.veterinaria.servidor.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public abstract Producto actualizaFotos(Producto bean);
	
	//CONSULTAS
	public abstract List<Producto> listaProductoByNombre(String nombre);
	public abstract Page<Producto> listaProductoByNombreAaZ(Pageable pageable);
	public abstract Page<Producto> listaProductoByNombreZaA(Pageable pageable);
	public abstract Page<Producto> listaProductoByPrecioMenorMayor(Pageable pageable);
	public abstract Page<Producto> listaProductoByPrecioMayoraMenor(Pageable pageable);
	public abstract Page<Producto> listaAllProducto(Pageable pageable);
	
	//SUBIR ARCHIVOS
	public abstract void saveFile(MultipartFile file) throws Exception;
	
	public abstract void saveFotos(List<MultipartFile> files) throws IOException;
	
}
