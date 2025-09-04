package com.mx.Herencia;

public class Principal {
	
	public static void main(String[]args) {
		//instanciar el objeto
		Hijo hijo1 = new Hijo("Martin", "Morales", 12, "Moreno", 1.20, "Mexicana", "delgado", "negro", "negro");
		
		System.out.println(hijo1);
		
		hijo1.setEdad(21);
		hijo1.setAltura(1.92);
		hijo1.setNombre("Julian");
		
		System.out.println("Hijo actualizado \n" + hijo1);
		
		hijo1.trabajar();
	}

}
