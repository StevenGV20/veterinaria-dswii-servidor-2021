package com.veterinaria.servidor.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor	
public class ProductoRequest {
	private int idproducto;
	private String nombre;
	private double precio;
	private int stock;
	private String marca;
	private String descripcionSimple;
	private String descripcionHTML;
	private String foto1;
	private String foto2;
	private String foto3;
	private Categoria idcategoria;
	private List<MultipartFile> files;
}
