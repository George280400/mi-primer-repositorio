package com.mx.AutorLibro.Dominio;
import jakarta.validation.constraints.NotBlank; 
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table //si no especifico el nombre tomara por defecto el nombre de mi clase y mapeara ala tabla que coincida

public class Autor {
	
	@Id
	private int idAutor;
	@NotBlank(message = "El nombre no puede estar vacío")
	private String nombre;
	@OneToMany(mappedBy = "autorId", cascade = CascadeType.ALL)
	List<Libros> list = new ArrayList<>();
	
public Autor() {
	
}

public Autor(int idAutor, String nombre) {
	super();
	this.idAutor = idAutor;
	this.nombre = nombre;
}

public int getIdAutor() {
	return idAutor;
}

public void setIdAutor(int idAutor) {
	this.idAutor = idAutor;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

@Override
public String toString() {
	return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + "]";
}



}
