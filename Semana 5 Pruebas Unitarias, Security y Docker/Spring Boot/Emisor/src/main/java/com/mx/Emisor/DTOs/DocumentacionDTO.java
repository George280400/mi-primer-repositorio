package com.mx.Emisor.DTOs;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DocumentacionDTO {
	
	private String tipoIdentificacion; 
	private String numeroIdentificacion;

}
