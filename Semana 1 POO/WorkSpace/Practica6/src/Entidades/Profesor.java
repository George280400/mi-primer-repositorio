package Entidades;

public abstract class Profesor {
	
	protected String nombre;
    protected String apellido;
    protected int edad;
    protected int experiencia;
	
  //metodo concreto personalizado
  	public void cobrar(String nivel, double sueldo) {
  		System.out.println("trabajo como mestro nivel : " + nivel + " y me pagan " + sueldo + " al dia");
  	}
	
	//metodo abstracto
	
	public abstract void trabajar();
	
	public Profesor() {
		
	}

	public Profesor(String nombre, String apellido, int edad, int experiencia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.experiencia = experiencia;
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

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", experiencia="
				+ experiencia + "]";
	}
	
	
	

}
