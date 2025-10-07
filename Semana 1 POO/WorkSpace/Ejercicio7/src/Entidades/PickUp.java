package Entidades;

public class PickUp extends Automovil{
	
	private int capacidadCarga;
	
	//metodo personalizado
	
	public String mostrarDatos() {
		return "Automovil\n" + "Marca" +this.marca + "\nSubmarca" + this.submarca + "\nModelo" + this.modelo +
				"\nCapacidad de carga " + this.capacidadCarga;
		
	
	
	
	}
public PickUp() {
		
	}

	public PickUp(String marca, String submarca, String modelo, int capacidadCarga) {
		super(marca, submarca, modelo);
		this.capacidadCarga = capacidadCarga;
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	@Override
	public String toString() {
		return "PickUp [marca=" + marca + ", submarca=" + submarca + ", modelo=" + modelo + ", capacidadCarga="
				+ capacidadCarga + "]";
	}
	
	

}
