package com.mx.Responsables.DTOs;

import lombok.Data;

@Data
public class ResponsableResponseDTO {
	
	private int idResponsable;
	private String nombre;
	private String contacto;
	
	private int veterinariaId;
    private String nombreVeterinaria;

}
