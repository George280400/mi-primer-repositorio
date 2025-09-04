package com.mx.Celular;
//una interfaz es como una plantilla para que nos ayuda para la construccion de otras clases}
public interface IMetodos {
	
	//las interfaces solo pueden tener metodos abstractos
	 public void guardar(Celular celular);
	 public void editar(int indice, Celular celular);
	 public void mostrar();
	 public void eliminar(int indice);
	 public Celular buscar(int indice);

}
