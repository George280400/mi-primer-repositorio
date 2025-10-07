package com.mx.Producto.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //indica que esta clase es una representacion de la bvase de datos
@Table(name = "PRODUCTOS") //mapea dentro de la base de datos  la tabla que estoy representando
//si el nombre de mi clase no coincide con mi tabla, debo especificar que tabla se debe mapear
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Data simplifica todas las notaciones que ocupe
public class Producto {
	
	@Id
	private long codigoBarras;
	private String nombre;
	private double precio;
	private int stock;
	private int descuento;
	private int categoriaId;
	private int proveedorId;
	

}
