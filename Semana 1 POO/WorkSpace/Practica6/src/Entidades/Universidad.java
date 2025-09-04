package Entidades;

public class Universidad extends Profesor{
	
	private String nivel;
	private String materia;
	private double grado;

	@Override
	public void trabajar() {
		
		System.out.println("trabajo en la mañana");
		
	}
	
	public Universidad() {
		
	}

	public Universidad(String nombre, String apellido, int edad, int experiencia, String nivel, String materia,
			double grado) {
		super(nombre, apellido, edad, experiencia);
		this.nivel = nivel;
		this.materia = materia;
		this.grado = grado;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public double getGrado() {
		return grado;
	}

	public void setGrado(double grado) {
		this.grado = grado;
	}

	@Override
	public String toString() {
		return "Universidad [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", experiencia="
				+ experiencia + ", nivel=" + nivel + ", materia=" + materia + ", grado=" + grado + "]";
	}
	
	
	
	

}
