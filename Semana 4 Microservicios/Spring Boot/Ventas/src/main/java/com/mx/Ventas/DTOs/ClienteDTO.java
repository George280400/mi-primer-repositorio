package com.mx.Ventas.DTOs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClienteDTO {
	
	@Id
	private int idCliente;
	private String nombre;
	private String app;
	private String apm;
	private String telefono;


}
