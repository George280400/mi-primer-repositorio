package com.mx.Celular;

import java.util.ArrayList;
import java.util.List;

//para implementar una interfaz se usa la palabra reservada implements
public class Implementacion implements IMetodos{
	
	//definimos una estructura de datos para poder definir el comportamiento delos metodos
	//lista
	List<Celular> lista = new ArrayList<Celular>();

	@Override
	public void guardar(Celular celular) {
		// TODO Auto-generated method stub
		lista.add(celular);
	}

	@Override
	public void editar(int indice, Celular celular) {
		// TODO Auto-generated method stub
		lista.set(indice, celular);
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.println(lista);
		
	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		lista.remove(indice);
	}

	@Override
	public Celular buscar(int indice) {
		// TODO Auto-generated method stub
		return lista.get(indice);
	}
	
	//metod personalizado contar
	
	public void contar() {
		int contador = lista.size();
		System.out.println("La lista contiene" + contador + " celulares registrados");
	}

}
