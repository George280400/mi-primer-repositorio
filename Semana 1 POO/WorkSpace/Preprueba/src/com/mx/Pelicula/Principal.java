package com.mx.Pelicula;

public class Principal {

	public static void main(String[] args) {
		
		Pelicula pc1 = new Pelicula("El aro", 90, "Terror", "Jose Cervantes");
		Pelicula pc2 = new Pelicula("Esso", "Stephen King");
		
		SerieDocumental sc1 = new SerieDocumental("La vida en el desierto", 10, "Naturaleza", "Luis Fernando");
		SerieDocumental sc2 = new SerieDocumental("Vida Salvaje", "Fantasia");
		
		System.out.println("P  E  L  I  C  U  L  A  S");
		System.out.println(pc1);
		System.out.println("¿p1 disponible? " + pc1.isDisponible());
        pc1.ocupar();
        System.out.println("¿p1 disponible tras ocupar? " + pc1.isDisponible());
        pc1.liberar();
        System.out.println("¿p1 disponible tras liberar? " + pc1.isDisponible());
        
        System.out.println(pc2);
		System.out.println("¿p2 disponible? " + pc2.isDisponible());
        pc2.ocupar();
        System.out.println("¿p2 disponible tras ocupar? " + pc2.isDisponible());
        pc2.liberar();
        System.out.println("¿p2 disponible tras liberar? " + pc2.isDisponible());
        
        System.out.println("S  E  R  I  E  S");
        System.out.println(sc1);
        System.out.println("¿s1 disponible? " + sc1.isDisponible());
        sc1.ocupar();
        System.out.println("¿s1 disponible tras ocupar? " + sc1.isDisponible());
        sc1.liberar();
        System.out.println("¿s1 disponible tras liberar? " + sc1.isDisponible());
        
        System.out.println(sc2);
        System.out.println("¿s2 disponible? " + sc2.isDisponible());
        sc2.ocupar();
        System.out.println("¿s2 disponible tras ocupar? " + sc2.isDisponible());
        sc2.liberar();
        System.out.println("¿s2 disponible tras liberar? " + sc2.isDisponible());
        
        

	}

}
