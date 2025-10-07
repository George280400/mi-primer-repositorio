package com.mx.Proveedor.DTOs;

import java.util.List;

import com.mx.Proveedor.Entity.Proveedor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data    //genera automaticamente getters y setters para todos los atributos.
@AllArgsConstructor //genera un cosntructor con parametros
public class ProveedorProductoDTO {
	
	private Proveedor proveedor; //instancia objeto proveedor
	private List <ProductoDTO> productos; // lista de productos

}

// la clase junta el objeto proveedor y la lista de productos
