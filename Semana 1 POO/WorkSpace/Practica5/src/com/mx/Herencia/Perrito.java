package com.mx.Herencia;

public class Perrito extends Perro{
	
	private String colorOjos;
	private String colorPelo;
	private int meses;
	
	public Perrito() {
		
	}

	public Perrito(String nombre, String raza, String tamano, int edad, String colorOjos, String colorPelo, int meses) {
		super(nombre, raza, tamano, edad);
		this.colorOjos = colorOjos;
		this.colorPelo = colorPelo;
		this.meses = meses;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}

	public int getMeses() {
		return meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	@Override
	public String toString() {
		return "Perrito [nombre=" + nombre + ", raza=" + raza + ", tamano=" + tamano + ", edad=" + edad + ", colorOjos="
				+ colorOjos + ", colorPelo=" + colorPelo + ", meses=" + meses + "]\n";
	}
	
	
	
	

}
