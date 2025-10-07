package Entidades;

public class Turismo extends Automovil{
	
	private int numAsientos;
	
	//metodo personalizado
	public String mostrarDatos() {
		return "Automovil\n" + "Marca" +this.marca + "\nSubmarca" + this.submarca + "\nModelo" + this.modelo + "\nNum de asientos " + this.numAsientos ;
		
		
		
		
	}
	public Turismo() {
		
	}

	public Turismo(String marca, String submarca, String modelo, int numAsientos) {
		super(marca, submarca, modelo);
		this.numAsientos = numAsientos;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	@Override
	public String toString() {
		return "Turismo [marca=" + marca + ", submarca=" + submarca + ", modelo=" + modelo + ", numAsientos="
				+ numAsientos + "]";
	}
	
	

}
