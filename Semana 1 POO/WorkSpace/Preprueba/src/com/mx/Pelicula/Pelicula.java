package com.mx.Pelicula;

public class Pelicula  implements IMetodos{
	
	private String titulo;
	private int duracion = 90;
	private boolean disponible = true;
	private String genero;
	private String director;
	
	public Pelicula() {
		
	}
	
	

	public Pelicula(String titulo, String director) {
		super();
		this.titulo = titulo;
		this.director = director;
	}



	public Pelicula(String titulo, int duracion, String genero, String director) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.director = director;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public int getDuracion() {
		return duracion;
	}



	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", duracion=" + duracion + ", disponible=" + disponible + ", genero="
				+ genero + ", director=" + director + "]";
	}
	
    
	// ====== Métodos de la interfaz ======
    @Override
    public void ocupar() {
        this.disponible = false;
    }

    @Override
    public void liberar() {
        this.disponible = true;
    }

    @Override
    public boolean isDisponible() {
        return this.disponible;
    }
	
	 
}
