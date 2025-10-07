package Examen;

public class Serie  implements Entregable{
	
	private String titulo;
	private int noTemporadas = 3;
	private boolean entregado = false;
	private String genero;
	private String creador;
	
	public Serie() {
		
	}

	public Serie(String titulo, String creador) {
		super();
		this.titulo = titulo;
		this.creador = creador;
	}

	public Serie(String titulo, int noTemporadas, String genero, String creador) {
		super();
		this.titulo = titulo;
		this.noTemporadas = noTemporadas;
		this.genero = genero;
		this.creador = creador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNoTemporadas() {
		return noTemporadas;
	}

	public void setNoTemporadas(int noTemporadas) {
		this.noTemporadas = noTemporadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", noTemporadas=" + noTemporadas + ", entregado=" + entregado + ", genero="
				+ genero + ", creador=" + creador + "]";
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
		
		Serie otra = (Serie) a;  // Casteo: cambio de datos
        return Integer.compare(this.noTemporadas, otra.getNoTemporadas());
	}
	
	
	
	

}
