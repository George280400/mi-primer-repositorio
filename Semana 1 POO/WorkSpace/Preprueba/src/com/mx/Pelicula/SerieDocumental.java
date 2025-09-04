package com.mx.Pelicula;

public class SerieDocumental {
	
	private String titulo;
	private int noEpisodios = 5;
	private boolean disponible = true ;
	private String categoria;
	private String productor;
	
	public SerieDocumental() {
		
	}

	public SerieDocumental(String titulo, String categoria) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
	}

	public SerieDocumental(String titulo, int noEpisodios, String categoria, String productor) {
		super();
		this.titulo = titulo;
		this.noEpisodios = noEpisodios;
		this.categoria = categoria;
		this.productor = productor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNoEpisodios() {
		return noEpisodios;
	}

	public void setNoEpisodios(int noEpisodios) {
		this.noEpisodios = noEpisodios;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	@Override
	public String toString() {
		return "SerieDocumental [titulo=" + titulo + ", noEpisodios=" + noEpisodios + ", disponible=" + disponible
				+ ", categoria=" + categoria + ", productor=" + productor + "]";
	}
	
	public void ocupar() {
        this.disponible = false;
    }

    
    public void liberar() {
        this.disponible = true;
    }

    
    public boolean isDisponible() {
        return this.disponible;
    }
	
	
	

}
