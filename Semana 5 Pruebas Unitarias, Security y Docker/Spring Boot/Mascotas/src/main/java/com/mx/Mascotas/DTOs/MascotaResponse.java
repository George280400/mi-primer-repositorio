package com.mx.Mascotas.DTOs;

import lombok.Data;

@Data
public class MascotaResponse {
	
	private int idMascota;
    private String nombre;
    private String raza;
    private int edad;
    private String razonCita;

    private int clienteId;
    private String nombreCliente;

    private int responsableId;
    private String nombreResponsable;

}
