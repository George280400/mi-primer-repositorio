package com.mx.Herencia;

public class Padre {
	
	protected String nombre;
	protected String apellido;
	protected int edad;
	protected String tez;
	protected double altura;
	protected String nacionalidad;
	protected String complexion;
	
	//metodo personalizado
	public void trabajar() {
		System.out.println("trabajo todo el dia");
	}
	
	public Padre() {
		
	}

	public Padre(String nombre, String apellido, int edad, String tez, double altura, String nacionalidad,
			String complexion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.tez = tez;
		this.altura = altura;
		this.nacionalidad = nacionalidad;
		this.complexion = complexion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTez() {
		return tez;
	}

	public void setTez(String tez) {
		this.tez = tez;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getComplexion() {
		return complexion;
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}

	@Override
	public String toString() {
		return "Padre [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", tez=" + tez + ", altura="
				+ altura + ", nacionalidad=" + nacionalidad + ", complexion=" + complexion + "]\n";
	}
	
	
	

}
