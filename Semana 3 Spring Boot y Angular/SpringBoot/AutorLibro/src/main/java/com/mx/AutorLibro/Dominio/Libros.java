package com.mx.AutorLibro.Dominio;


import jakarta.validation.constraints.NotBlank; 

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class Libros {
	
	@Id
	private int idLibro;
	@NotBlank(message = "El nombre no puede estar vacío")
	private String titulo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AUTOR_ID")
	private Autor autorId;
	
	public Libros() {
		
	}

	public Libros(int idLibro, String titulo, Autor autorId) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autorId = autorId;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutorId() {
		return autorId;
	}

	public void setAutorId(Autor autorId) {
		this.autorId = autorId;
	}

	@Override
	public String toString() {
		return "Libros [idLibro=" + idLibro + ", titulo=" + titulo + ", autorId=" + autorId + "]";
	}
	
	

}
