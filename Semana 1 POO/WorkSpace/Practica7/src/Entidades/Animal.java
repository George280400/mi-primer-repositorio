package Entidades;

public class Animal {
	
	protected String nombre;
    protected String especie;
    protected int edad;
    
  //metodo personalizado
    public String mostrarDatos() {
		return "Animal\n" + "Nombre" +this.nombre + "\nEspecie" + this.especie + "\nEdad" + this.edad;
	}
    
    public Animal () {
    	
    }

	public Animal(String nombre, String especie, int edad) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + "]";
	}
    
    

}
