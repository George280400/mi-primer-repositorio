package Entidades;

public class Gallo extends Animal{
	
	private String cacaraqueo;
	
	//metodo personalizado
	public String mostrarDatos() {
		return "Animal\n" + "nombre" +this.nombre + "\nEspecie" + this.especie + "\nEdad" + this.edad +
				"\nSonido que emite " + this.cacaraqueo;
	}
	
	public Gallo() {
		
	}

	public Gallo(String nombre, String especie, int edad, String cacaraqueo) {
		super(nombre, especie, edad);
		this.cacaraqueo = cacaraqueo;
	}

	public String getCacaraqueo() {
		return cacaraqueo;
	}

	public void setCacaraqueo(String cacaraqueo) {
		this.cacaraqueo = cacaraqueo;
	}

	@Override
	public String toString() {
		return "Gallo [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", cacaraqueo=" + cacaraqueo
				+ "]";
	}
	
	

}
