package com.mx.Moto;

public class Moto {
	
	private String marca;
	private String color;
	private int precio;
	private int marchas;
	
	public Moto()
	{
		
	}

	public Moto(String marca, String color, int precio, int marchas) {
		super();
		this.marca = marca;
		this.color = color;
		this.precio = precio;
		this.marchas = marchas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

	public int getMarchas() {
		return marchas;
	}

	public void setMarchas(int marchas) {
		this.marchas = marchas;
	}

	@Override
	public String toString() {
		return "Moto [marca=" + marca + ", color=" + color + ", precio=" + precio + ", marchas=" + marchas + "]\n";
	}
	
	
	
	

}
