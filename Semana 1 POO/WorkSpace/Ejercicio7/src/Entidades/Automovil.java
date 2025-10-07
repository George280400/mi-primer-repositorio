package Entidades;

public class Automovil {
	
	protected String marca;
	protected String submarca;
	protected String modelo;
	
	//metodo personalizado
	public String mostrarDatos() {
		return "Automovil\n" + "Marca" +this.marca + "\nSubmarca" + this.submarca + "\nModelo" + this.modelo;
	}
	
	public Automovil() {
		
	}

	public Automovil(String marca, String submarca, String modelo) {
		super();
		this.marca = marca;
		this.submarca = submarca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSubmarca() {
		return submarca;
	}

	public void setSubmarca(String submarca) {
		this.submarca = submarca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Automovil [marca=" + marca + ", submarca=" + submarca + ", modelo=" + modelo + "]";
	}
	
	

}
