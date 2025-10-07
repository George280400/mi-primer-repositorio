package Examen;

public class Videojuego implements Entregable{
	
	private String titulo;
	private int horasEstimadas = 10;
	private boolean entregado = false;
	private String genero;
	private String compania;
	
	public Videojuego() {
		
	}

	public Videojuego(String titulo, int horasEstimadas) {
		super();
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
	}

	public Videojuego(String titulo, int horasEstimadas, String genero, String compania) {
		super();
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = genero;
		this.compania = compania;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", horasEstimadas=" + horasEstimadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", compania=" + compania + "]";
	}

	@Override
	public void entregar() {
		
		this.entregado = true;
		
	}

	@Override
	public void devolver() {
		
		this.entregado = false;
		
	}

	@Override
	public boolean isEntregado() {
		
		return this.entregado;
		
	}

	@Override
	public int compareTo(Object a) {
		
		 Videojuego otro = (Videojuego) a;  // Casteo: cambio de datos
	        return Integer.compare(this.horasEstimadas, otro.getHorasEstimadas());
	}
	
	
	

}
