package com.mx.Libro;

import java.util.HashMap;


public class Implementacion implements IMetodos {
	
	HashMap<String, Libro> hash = new HashMap<String, Libro>();

	@Override
	public void guardar(Libro libro) {
		
		hash.put(libro.getNombre(), libro);
	}

	@Override
	public Libro buscar(Libro libro) {
		
		return hash.get(libro.getNombre());
	}

	@Override
	public void editar(Libro libro) {
		
		hash.replace(libro.getNombre(), libro);
	}

	@Override
	public void eliminar(Libro libro) {
		
		hash.remove(libro.getNombre());
	}

	@Override
	public void mostrar() {
		
		System.out.println(hash);
	}
	
	//metodo personalizado
	
	public void contar()
	{
		System.out.println("el hashmap contiene " + hash.size() + " libros");
	}

}
