package com.mx.Computadora.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //es de Data JPA indica que mi clase  sera la representacion de una entidad en la base de datos
@Table(name = "COMPUTADORA") //es de DataJPA indica la tabla que estoy representando con mi clase
//mapea dentro la BD y busca dentro de mi conexion si el nombre de la tabla coincide y realiza la conexion
public class Computadora {
	@Id //es de DataJPA y es para especificar que el atributo que sigue despues de esta anotacion es el identificador de mi clase
	@GeneratedValue(strategy = GenerationType.IDENTITY)// le indico a spring que el identificador se generara automaticamente
	//ID_COMPU usar camelcase
	private int idCompu;
	@Column(name = "MARCA", columnDefinition = "NVARCHAR2(100)") //DataJPA es para mapear el nombre de la columna en la BD  a mi atributo en java
	private String marca;
	@Column(name = "MODELO", columnDefinition = "NVARCHAR2(100)")
	private String modelo;
	@Column(name = "PROCESADOR", columnDefinition = "NVARCHAR2(100)")
	private String procesador;
	@Column(name = "RAM", columnDefinition = "NUMBER")
	private int ram;
	@Column(name = "CAPACIDAD", columnDefinition = "NVARCHAR2(10)")
	private String capacidad;
	@Column(name = "COLOR", columnDefinition = "NVARCHAR2(100)")
	private String color;
	@Column(name = "PRECIO", columnDefinition = "NUMBER")
	private int precio;
	
	public Computadora() {
		}

	public Computadora(int idCompu, String marca, String modelo, String procesador, int ram, String capacidad,
			String color, int precio) {
		super();
		this.idCompu = idCompu;
		this.marca = marca;
		this.modelo = modelo;
		this.procesador = procesador;
		this.ram = ram;
		this.capacidad = capacidad;
		this.color = color;
		this.precio = precio;
	}

	public int getIdCompu() {
		return idCompu;
	}

	public void setIdCompu(int idCompu) {
		this.idCompu = idCompu;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Computadora [idCompu=" + idCompu + ", marca=" + marca + ", modelo=" + modelo + ", procesador="
				+ procesador + ", ram=" + ram + ", capacidad=" + capacidad + ", color=" + color + ", precio=" + precio
				+ "]";
	}
	
	
	}
