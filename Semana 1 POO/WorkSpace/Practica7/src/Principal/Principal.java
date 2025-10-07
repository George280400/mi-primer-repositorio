package Principal;

import Entidades.Animal;
import Entidades.Gallo;
import Entidades.Gato;
import Entidades.Perro;

public class Principal {

	public static void main(String[] args) {
		//crear un array de 4 posiciones
				Animal[]an = new Animal[4];
				an[0] = new Animal("Aguila", "Ave", 15);
				an[1] = new Perro("Max", "Canino", 6, "Guau");
				an[2] = new Gato("Otis", "Felino", 2, "Miau");
				an[3] = new Gallo("Claudio", "Ave", 1, "Ki ki ri ki");
				
				for(Animal animal: an) {
					System.out.println(animal.mostrarDatos());
					System.out.println(animal);
				}

	}

}
