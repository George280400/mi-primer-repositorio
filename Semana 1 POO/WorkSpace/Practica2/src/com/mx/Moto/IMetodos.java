package com.mx.Moto;


public interface IMetodos {
	
	//las interfaces solo pueden tener metodos abstractos
		 public void guardar(Moto moto);
		 public void editar(int indice, Moto moto);
		 public void mostrar();
		 public void eliminar(int indice);
		 public Moto buscar(int indice);

}
