package com.mx.Categoria.DTOs;

import jakarta.persistence.Id;
import lombok.Data;
@Data
public class ProductoDTO {
	
	private long codigoBarras;
	private String nombre;
	private double precio;
	private int stock;
	private int descuento;
	private int categoriaId;
	private int proveedorId;

}

//DTO es un data transfer object(objeto de transferencia de datos)
//es una clase que solo contiene datos sin un logica de negocios
//su proposito principal es transportar la informacion entre capas de una aplicacion o entre microservicios
//generalmente incluyen atributos, constructores getters y setters pero no metodos complejos
