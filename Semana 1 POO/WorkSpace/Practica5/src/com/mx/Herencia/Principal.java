package com.mx.Herencia;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Perrito p1 = new Perrito("Max", "Chihuahua", "Pequeño", 0, "cafes", "blanco", 2);
		
System.out.println(p1);
		
		p1.setNombre("Tobi");
		p1.setColorPelo("negro");
		p1.setRaza("bull terry");
		p1.setMeses(8);
		
		System.out.println("Perrito actualizado \n" + p1);
		
		p1.ladrar();
		
		

	}

}
