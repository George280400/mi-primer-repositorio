package com.mx.Receptor.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContratoDTO {
	
	private String idContrato; 
	private String fechaExpiracion;

}
