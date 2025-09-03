package Entidades;

public class Persona {
	
	private String nombre;
	private String apellido;
	private int edad;
	private String nacionalidad;
	

	public Persona() {
		
	}


	public Persona(String nombre, String apellido, int edad, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
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


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", nacionalidad="
				+ nacionalidad + "]\n";
	}
	
	

}
