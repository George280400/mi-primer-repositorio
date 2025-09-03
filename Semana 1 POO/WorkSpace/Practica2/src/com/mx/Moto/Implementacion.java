package com.mx.Moto;

import java.util.ArrayList;
import java.util.List;


public class Implementacion implements IMetodos {
	
	List<Moto> lista = new ArrayList<Moto>();

	@Override
	public void guardar(Moto moto) {
		// TODO Auto-generated method stub
		lista.add(moto);
	}

	@Override
	public void editar(int indice, Moto moto) {
		// TODO Auto-generated method stub
		lista.set(indice, moto);
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
	public Moto buscar(int indice) {
		// TODO Auto-generated method stub
		return lista.get(indice);
	}
	
	//metod personalizado contar
	
		public void contar() {
			int contador = lista.size();
			System.out.println("La lista contiene " + contador + " motos registradas");
		}

}
