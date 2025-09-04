package com.mx.Herencia;

public class Perro {
	
	protected String nombre;
	protected String raza;
	protected String tamano;
	protected int edad;
	
	
	//metodo personalizado
	public void ladrar() {
		System.out.println( nombre + " esta ladrando");
	}
	
	public Perro() {
		
	}

	public Perro(String nombre, String raza, String tamano, int edad) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.tamano = tamano;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + ", tamano=" + tamano + ", edad=" + edad + "]";
	}
	
	
	

}
