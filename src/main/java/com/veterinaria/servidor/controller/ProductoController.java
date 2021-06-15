package com.veterinaria.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.servidor.entity.Producto;
import com.veterinaria.servidor.service.ProductoService;
import com.veterinaria.servidor.util.Constantes;

@RestController
@CrossOrigin(origins = {"http://localhost:8090","http://localhost:8091"}, 
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping(value = "/producto")
public class ProductoController {
	@Autowired
	private ProductoService service;
	
	@ResponseBody
	@GetMapping(value = "/lista")
	public List<Producto> listaProducto(){
		return service.listaProducto();
	}
	
	@GetMapping(value = "/buscaProductoById/{cod}")
	@ResponseBody
	public  Optional<Producto> buscaProductoById(@PathVariable("cod")int cod){
		return service.buscaProductoPorId(cod);
	}
	
	@GetMapping(value = "/listaProductosByNombre/{nombre}")
	@ResponseBody
	public List<Producto> listaProductosByNombre(@PathVariable("nombre") String nombre){
		List<Producto> lista= service.listaProductoByNombre(nombre);
		return lista;
	}
	
	@GetMapping(value = "/listaProductosByNombreAaZ/{page}")
	@ResponseBody
	public Page<Producto> listaProductosByAaZ(@PathVariable("page") int num){
		Pageable paginacion=PageRequest.of(num, 6);
		Page<Producto> lista= service.listaProductoByNombreAaZ(paginacion);
		return lista;
	}
	@GetMapping(value = "/listaProductosByNombreZaA/{page}")
	@ResponseBody
	public Page<Producto> listaProductosByNombreZaA(@PathVariable("page") int num){
		Pageable paginacion=PageRequest.of(num, 6);
		Page<Producto> lista= service.listaProductoByNombreZaA(paginacion);
		return lista;
	}
	@GetMapping(value = "/listaProductoByPrecioMenorMayor/{page}")
	@ResponseBody
	public Page<Producto> listaProductoByPrecioMenorMayor(@PathVariable("page") int num){
		Pageable paginacion=PageRequest.of(num, 6);
		Page<Producto> lista= service.listaProductoByPrecioMenorMayor(paginacion);
		return lista;
	}
	@GetMapping(value = "/listaProductoByPrecioMayoraMenor/{page}")
	@ResponseBody
	public Page<Producto> listaProductoByPrecioMayoraMenor(@PathVariable("page") int num){
		Pageable paginacion=PageRequest.of(num, 6);
		Page<Producto> lista= service.listaProductoByPrecioMayoraMenor(paginacion);
		return lista;
	}
	@GetMapping(value = "/listaByPage/{page}")
	@ResponseBody
	public Page<Producto> listaByPage(@PathVariable("page") int num){
		Pageable paginacion=PageRequest.of(num, 6);
		Page<Producto> lista= service.listaAllProducto(paginacion);
		return lista;
	}
	
	
	@GetMapping(value = "/buscaProductoXID/{id}")
	@ResponseBody
	public Optional<Producto> buscaProductoXID(@PathVariable(name = "id") int id){
		Optional<Producto> producto= service.buscaProductoPorId(id);
		return producto;
	}
	
	
	@PostMapping("/registra")
	@ResponseBody
	public ResponseEntity<?> registra(Producto obj){
		try {
			/*Producto pro=new Producto();
			pro.setNombre(obj.getNombre());
			pro.setPrecio(obj.getPrecio());
			pro.setStock(obj.getStock());
			pro.setMarca(obj.getMarca());
			pro.setDescripcionSimple(obj.getDescripcionSimple());
			pro.setDescripcionHTML(obj.getDescripcionHTML());
			pro.setIdcategoria(obj.getIdcategoria());*/
			System.out.println("categoria "+obj.getIdcategoria().getIdcategoria());
			//if(obj.getFoto1()==null) obj.setFoto1("img/image-not-found.png");
			//if(obj.getFoto2()==null)obj.setFoto2("img/image-not-found.png");
			//if(obj.getFoto3()==null) obj.setFoto3("img/image-not-found.png");
			/*if(obj.getFiles().size()!=0) {
				//service.saveFotos(files);
				int c=0;
				for(MultipartFile file:obj.getFiles()) {
					
					if(!(file.getBytes()==null)) {
						System.out.println("FILE: "+file.getOriginalFilename());
						if(c==0) pro.setFoto1(file.getOriginalFilename());
						else if(c==1)pro.setFoto2(file.getOriginalFilename());
						else if(c==2) pro.setFoto3(file.getOriginalFilename());						
					}else {
						if(c==0) pro.setFoto1("image-not-found.png");
						else if(c==1)pro.setFoto2("image-not-found.png");
						else if(c==2) pro.setFoto3("image-not-found.png");
					}
					System.out.println(c);
					c++;
				}
			}*/
			
			return ResponseEntity.ok(service.mantenerProducto(obj));
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "Se produjo un error");
		}
	}
	
	@PutMapping("/subirFotos")
	public ResponseEntity<?> subirFotos(@RequestBody Producto obj){
		try {
			System.out.println("Estamos aqui en la subida de fotos");
			if(obj.getFoto1()==null) obj.setFoto1("img/image-not-found.png");
			if(obj.getFoto2()==null)obj.setFoto2("img/image-not-found.png");
			if(obj.getFoto3()==null) obj.setFoto3("img/image-not-found.png");
			return ResponseEntity.ok(service.actualizaFotos(obj));
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "Se produjo un error");
		}
	}
	
	@PutMapping("/actualiza")
	public ResponseEntity<?> actualiza(@RequestBody Producto obj){
		try {
			return ResponseEntity.ok(service.mantenerProducto(obj));
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "Se produjo un error");
		}
	}
	
	@DeleteMapping(path = "/elimina/{id}")
	public ResponseEntity<?> eliminaCliente(@PathVariable(name = "id") int id) {
		try {
			service.eliminaProducto(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Constantes.mensaje(HttpStatus.BAD_REQUEST, "Error", "Se produjo un error");
		}
	}
	
}
