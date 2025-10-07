package com.mx.Carros.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //LA CLASE REPRESENTARA LA TABLA "CARROS" DE LA TABLA DE LA BASE DE DATOS DE ORACLE
@Table (name = "CARROS") //BUSCA EN LA BASE DE DATOS LA TABLA CARROS
public class Carros {
	
	@Id // ES PARA VER ASIGNAR EL IDENTIFICADOR DE LA CLASE
	@GeneratedValue(strategy = GenerationType.IDENTITY)// EL  IDENTIFICADOR SE GENERA DE FORMA AUTOMATICA
	
	//ID_COMPU usar camelcase
	private int idCarro;
	
	@Column(name = "MARCA", columnDefinition = "NVARCHAR2(100)") //DataJPA es para mapear el nombre de la columna en la BD  a mi atributo en java
	private String marca;
	
	@Column(name = "MODELO", columnDefinition = "NVARCHAR2(100)")
	private String modelo;
	
	@Column(name = "ANIO", columnDefinition = "NUMBER")
	private int anio;
	
	@Column(name = "COLOR", columnDefinition = "NVARCHAR2(50)")
	private String color;
	
	@Column(name = "MOTOR", columnDefinition = "NVARCHAR2(100)")
	private String motor;
	
	@Column(name = "TRANSMISION", columnDefinition = "NVARCHAR2(50)")
	private String transmision;
	
	@Column(name = "PRECIO", columnDefinition = "NUMBER")
	private int precio;
	
	public Carros() {
		
	}

	public Carros(int idCarro, String marca, String modelo, int anio, String color, String motor, String transmision,
			int precio) {
		super();
		this.idCarro = idCarro;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.color = color;
		this.motor = motor;
		this.transmision = transmision;
		this.precio = precio;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Carros [idCarro=" + idCarro + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", color="
				+ color + ", motor=" + motor + ", transmision=" + transmision + ", precio=" + precio + "]";
	}

	
	
	

}
