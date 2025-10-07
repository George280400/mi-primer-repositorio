package Entidades;

public class Deportivo extends Automovil{
	
	private int noCilindros;
	
	//metodo personalizado
	public String mostrarDatos() {
		return "Automovil\n" + "Marca" +this.marca + "\nSubmarca" + this.submarca + "\nModelo" + this.modelo +
				"\nNum de Cilindros " + this.noCilindros;
	}
	
	public Deportivo() {
		
	}

	public Deportivo(String marca, String submarca, String modelo, int noCilindros) {
		super(marca, submarca, modelo);
		this.noCilindros = noCilindros;
	}

	public int getNoCilindros() {
		return noCilindros;
	}

	public void setNoCilindros(int noCilindros) {
		this.noCilindros = noCilindros;
	}

	@Override
	public String toString() {
		return "Deportivo [marca=" + marca + ", submarca=" + submarca + ", modelo=" + modelo + ", noCilindros="
				+ noCilindros + "]";
	}
	
	
	

}
