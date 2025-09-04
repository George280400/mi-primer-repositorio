package com.mx.Herencia;

public class Hijo  extends Padre{
	
	private String colorOjos;
	private String colorCabello;
	
	public Hijo() {
		
	}

	public Hijo(String nombre, String apellido, int edad, String tez, double altura, String nacionalidad,
			String complexion, String colorOjos, String colorCabello) {
		super(nombre, apellido, edad, tez, altura, nacionalidad, complexion);
		this.colorOjos = colorOjos;
		this.colorCabello = colorCabello;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public String getColorCabello() {
		return colorCabello;
	}

	public void setColorCabello(String colorCabello) {
		this.colorCabello = colorCabello;
	}

	@Override
	public String toString() {
		return "Hijo [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", tez=" + tez + ", altura="
				+ altura + ", nacionalidad=" + nacionalidad + ", complexion=" + complexion + ", colorOjos=" + colorOjos
				+ ", colorCabello=" + colorCabello + "]";
	}
	
	
	

}
