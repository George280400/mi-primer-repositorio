package com.mx.Libro;



public class Principal {

	public static void main(String[] args) {
		
		
		//instancia del objeto
				Libro l1 = new Libro("El Quijote", "Miguel de Cervantes", "Santillana", "Clásico", 299.99);
				Libro l2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "Sudamericana", "Realismo Mágico", 350.50);
				Libro l3 = new Libro("1984", "George Orwell", "Debolsillo", "Distopía", 280.00);
				Libro l4 = new Libro("El Principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", "Infantil", 199.99);
				Libro l5 = new Libro("La Sombra del Viento", "Carlos Ruiz Zafón", "Planeta", "Misterio", 420.75);

				
				//objeto auxiliar
				Libro lib = null;
				
				//implementacion
				
				Implementacion imp = new Implementacion();
				
				imp.guardar(l1);
				imp.guardar(l2);
				imp.guardar(l3);
				imp.guardar(l4);
				imp.guardar(l5);
				
				//mostrar
				imp.mostrar();
				
				//buscar
				lib = new Libro("El Quijote");
				lib = imp.buscar(lib);
				System.out.println("informacion completa  de libro" + lib);
				
				//editar
				System.out.println("EDITAR");
				 lib = new Libro("1984");
				 lib = imp.buscar(lib);
				 lib.setGenero("Terror");
				 lib.setPrecio(150.50);
				 imp.editar(lib);
				 
				 System.out.println("informacion encontrada" + lib);
				 
				 //eliminar
				 System.out.println("ELIMINAR");
				 lib = new Libro("La Sombra del Viento");
				 lib = imp.buscar(lib);
				 imp.eliminar(lib);
				 System.out.println("Lista actualizada");
				 imp.mostrar();
				 
				 //contar
				 imp.contar();
	}

}
