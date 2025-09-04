package Principal;

import Entidades.Carro;
import Entidades.Persona;
import Entidades.Moto;


import Implementacion.implementacionCarro;
import Implementacion.implementacionMoto;
import Implementacion.implementacionPersona;

public class Principal {
	
	 public static void main(String[] args) {
	
	Carro carro1 = new Carro("Volskwagen", "Jetta", "Gasolina", "Rojo");
	Carro carro2 = new Carro("Nissan", "tsuru", "gasolina", "azul");
	Carro carro3 = new Carro("Toyota", "corolla", "gasolina", "verde");
	Carro carro4 = new Carro("Chevrolet", "spark", "gasolina", "blanco");
	Carro carro5 = new Carro("dodge", "neon", "diesel", "negro");
	
	Persona gente1 = new Persona("Raul", "Jimenez", 25, "Mexicana");
	Persona gente2 = new Persona("Jorge", "Guzman", 26, "Mexicana");
	Persona gente3 = new Persona("Carlos", "Carrera", 27, "Mexicana");
	Persona gente4 = new Persona("Armando", "Mendoza", 28, "Mexicana");
	Persona gente5 = new Persona("Eduardo", "Garcia", 29, "Mexicana");
	
	// ObjetoS auxiliarES
    Carro car = null;
	Persona per = null;
	Moto mot = null;
    
    
 // Implementación
	
    implementacionCarro impC = new implementacionCarro();
    implementacionMoto impM = new implementacionMoto();
    implementacionPersona impP = new  implementacionPersona();
    System.out.println("G U A R D A R   C A R R O S");
    impC.guardar(carro1);
    impC.guardar(carro2);
    impC.guardar(carro3);
    impC.guardar(carro4);
    impC.guardar(carro5);
    impC.mostrar();
    
  //Eliminar
    System.out.println("E L I M I N A R   C A R R O S");
    impC.eliminar(carro1);
    impC.eliminar(carro2);
    impC.eliminar(carro3);
    impC.mostrar();
    


    // Mostrar

    impC.contar();
    

    System.out.println("G U A R D A R   G E N T E");
    impP.guardar(gente1);
    impP.guardar(gente2);
    impP.guardar(gente3);
    impP.guardar(gente4);
    impP.guardar(gente5);
    impP.mostrar();
    
  //Eliminar
    System.out.println("E L I M I N A R   G E N T E");
    impP.eliminar(gente1);
    impP.eliminar(gente2);
    impP.eliminar(gente3);
    impP.mostrar();
	 

    impP.contar();
    
    
    
    
	 }
    

}

