package com.veterinaria.servidor.util;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Constantes {

	public static final String MENSAJE_REG_YA_EXISTE = "Ya existe dicho registro.";
	public static final String MENSAJE_REG_ERROR = "No se registro, consulte con el administrador.";
	public static final String MENSAJE_REG_EXITOSO = "Se registro correctamente.";
	
	public static final String MENSAJE_ACT_YA_EXISTE = "Ya existe dicho registro.";
	public static final String MENSAJE_ACT_ERROR = "No se actualizo, consulte con el administrador.";
	public static final String MENSAJE_ACT_EXITOSO = "Se actualizo correctamente.";
	public static final String MENSAJE_ACT_NO_EXISTE_ID = "No existe el ID que se desea actualizar.";
	
	public static final String MENSAJE_ELI_ERROR = "No se elimino, ya que el registro esta relacionado.";
	public static final String MENSAJE_ELI_EXITOSO = "Se elimino correctamente.";
	public static final String MENSAJE_ELI_NO_EXISTE_ID = "No existe el ID que se desea eliminar.";
	
	public static final String MENSAJE_ERROR = "Hubo un error en el proceso";
	
	public static ResponseEntity<?> mensaje(HttpStatus status,String title,String detail){
		return ResponseEntity
				.status(status)
				.header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
				.body(Problem.create()
						.withTitle(title)
						.withDetail(detail));
	}
	
	
}
