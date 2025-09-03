package Entidades;

public class Carro {
	
	private String marca;
	private String modelo;
	private String tipo;
	private String color;
	

	
	public Carro() {
		
	}



	public Carro(String marca, String modelo, String tipo, String color) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.color = color;
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



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	@Override
	public String toString() {
		return "Carro [marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", color=" + color + "]\n";
	}
	
	

}
