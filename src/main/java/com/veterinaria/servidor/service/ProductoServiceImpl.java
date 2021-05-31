package com.veterinaria.servidor.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.veterinaria.servidor.entity.Categoria;
import com.veterinaria.servidor.entity.Producto;
import com.veterinaria.servidor.repository.CategoriaRepository;
import com.veterinaria.servidor.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private String ruta=".//src//main//resources//static//img//";
	
	@Autowired
	private ProductoRepository repository;
	
	@Autowired 
	private CategoriaRepository catrepository;

	@Override
	public List<Categoria> listaCategeoria() {
		return catrepository.findAll();
	}

	@Override
	public List<Producto> listaProducto() {
		return repository.findAll();
	}

	@Override
	public Producto mantenerProducto(Producto bean) {
		return repository.save(bean);
	}

	@Override
	public Optional<Producto> buscaProductoPorId(int idproducto) {
		return repository.findById(idproducto);
	}

	@Override
	public void eliminaProducto(int idproducto) {
		repository.deleteById(idproducto);
	}
	

	@Override
	public void saveFile(MultipartFile file) throws Exception {
		
		if(!file.isEmpty()) {
			byte[] bytes=file.getBytes();
			Path path=Paths.get(ruta + file.getOriginalFilename());
			Files.write(path, bytes);
		}
		
	}

	@Override
	public void saveFotos(List<MultipartFile> files) throws IOException {
		for(MultipartFile file:files) {
			if(file.isEmpty()) continue;
			byte[] bytes=file.getBytes();
			Path path=Paths.get(ruta + file.getOriginalFilename());
			Files.write(path, bytes);
		}
	}

	@Override
	public Producto detalleProductoXID(int idproducto) {
		return repository.findById(idproducto).orElse(null);
	}

	@Override
	public List<Producto> listaProductoByNombre(String nombre) {
		return repository.listaProductoByName(nombre+"%");
	}

	@Override
	public List<Producto> listaProductoByNombreAaZ() {
		return repository.listaProductoByNameAaZ();
	}

	@Override
	public List<Producto> listaProductoByNombreZaA() {
		return repository.listaProductoByNameZaA();
	}

	@Override
	public List<Producto> listaProductoByPrecioMenorMayor() {
		return repository.listaProductoByPrecioMenor();
	}

	@Override
	public List<Producto> listaProductoByPrecioMayoraMenor() {
		return repository.listaProductoByPrecioMayor();
	}
	
	
		
}
