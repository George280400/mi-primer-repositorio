package com.mx.Libro;

public class Libro {
	
	private String nombre; //clave
	private String autor;
	private String editorial;
	private String genero;
	private double precio;
	
	public Libro() {
		
	}

	public Libro(String nombre, String autor, String editorial, String genero, double precio) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.editorial = editorial;
		this.genero = genero;
		this.precio = precio;
	}

	public Libro(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero
				+ ", precio=" + precio + "]\n";
	}
	
	

}
