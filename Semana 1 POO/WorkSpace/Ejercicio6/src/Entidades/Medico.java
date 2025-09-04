package Entidades;

public class Medico extends Profesionista{
	
	private String especialidad;
	private String consultorio;
	private double costoCosulta;

	@Override
	public void trabajar() {
		
		System.out.println("trabajo en turnos nocturnos");
		
	}
	
	public Medico() {
		
	}

	public Medico(String nombre, String apellido, int edad, int cedula, String universidad, int experiencia,
			String especialidad, String consultorio, double costoCosulta) {
		super(nombre, apellido, edad, cedula, universidad, experiencia);
		this.especialidad = especialidad;
		this.consultorio = consultorio;
		this.costoCosulta = costoCosulta;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public double getCostoCosulta() {
		return costoCosulta;
	}

	public void setCostoCosulta(double costoCosulta) {
		this.costoCosulta = costoCosulta;
	}

	@Override
	public String toString() {
		return "Medico [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cedula=" + cedula
				+ ", universidad=" + universidad + ", experiencia=" + experiencia + ", especialidad=" + especialidad
				+ ", consultorio=" + consultorio + ", costoCosulta=" + costoCosulta + "]";
	}
	
	
	
	

}
