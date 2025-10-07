package com.mx.Proveedor.DTOs;

import lombok.Data;

@Data ////genera automaticamente getters y setters para todos los atributos.
public class ProductoDTO {
	
	private long codigoBarras;
	private String nombre;
	private double precio;
	private int stock;
	private int descuento;
	private int categoriaId;
	private int proveedorId;
	
	//Un DTO (Data Transfer Object) es una clase que solo contiene datos (atributos, constructores, getters y setters) 
	//sin lógica de negocio, y su objetivo es transportar información microservicios.

}
