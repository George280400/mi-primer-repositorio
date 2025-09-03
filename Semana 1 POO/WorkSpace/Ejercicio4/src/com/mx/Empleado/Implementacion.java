package com.mx.Empleado;

import java.util.HashMap;

public class Implementacion implements IMetodos{
	
	//sintaxis del HashMap
	//HashMap<key VALOR> hash = new HashMap, Value ((;
	//HashMap es una libreria de java.util
	//KeyDataType -> clase contenedora del dato primitivo de la clabe
	//ValueDataType -> el nombre de la clase
	
	HashMap<String, Empleado> hash = new HashMap<String, Empleado>();

	@Override
	public void guardar(Empleado empleado) {
		// TODO Auto-generated method stub
		hash.put(empleado.getNombre(), empleado);
		
	}

	@Override
	public Empleado buscar(Empleado empleado) {
		
		return hash.get(empleado.getNombre());
	}

	@Override
	public void editar(Empleado empleado) {
		
		hash.replace(empleado.getNombre(), empleado);
	}

	@Override
	public void eliminar(Empleado empleado) {
		
		hash.remove(empleado.getNombre());
	}

	@Override
	public void mostrar() {
		
		System.out.println(hash);
		
	}
	
	//metodo personalizado
	public void contar()
	{
		System.out.println("el hashmap contiene " + hash.size() + " empleados");
	}
	
	

}
