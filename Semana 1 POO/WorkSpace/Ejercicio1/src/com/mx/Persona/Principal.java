package com.mx.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	// metodo que hace que compile el programa
	public static void main(String[] args) {

		Persona gente1 = new Persona("Raul", "Jimenez", 25, "Mexicana");
		Persona gente2 = new Persona("Jorge", "Guzman", 26, "Mexicana");
		Persona gente3 = new Persona("Carlos", "Carrera", 27, "Mexicana");
		Persona gente4 = new Persona("Armando", "Mendoza", 28, "Mexicana");
		Persona gente5 = new Persona("Eduardo", "Garcia", 29, "Mexicana");

		List<Persona> lista = new ArrayList<Persona>();

		lista.add(gente1);
		lista.add(gente2);
		lista.add(gente3);
		lista.add(gente4);
		lista.add(gente5);
		

		Persona perso = null;
		Scanner scan = null;

		int menuPrincipal = 0, menuSecundario = 0, indice = 0;

		// variables locales
		String nombre, apellido, nacionalidad;
		int edad;

		do {
			System.out.println("---MENU---");
			System.out.println("1 agregar un nuevo registro");
			System.out.println("2 mostrar la lista");
			System.out.println("3 editar");
			System.out.println("4 buscar un elemento en la lista");
			System.out.println("5 eliminar un elemento");
			System.out.println("6 contar todos los elementos");
			System.out.println("7 salir del menu");
			System.out.println("--- ELIGE UNA OPCION DENTRO DEL MENU---");

			scan = new Scanner(System.in);
			menuPrincipal = scan.nextInt();

			switch (menuPrincipal) {
			case 1: {
				System.out.println("1 agregar un nuevo registro");
				System.out.println("escriba el nombre de la persona");
				scan = new Scanner(System.in);
				nombre = scan.nextLine();

				System.out.println("escriba el apellido de la persona");
				scan = new Scanner(System.in);
				apellido = scan.nextLine();

				System.out.println("escriba la edad de la persona");
				scan = new Scanner(System.in);
				edad = scan.nextInt();
				scan.nextLine(); // limpieza del buffer

				System.out.println("escriba la nacionalidad de la persona");
				scan = new Scanner(System.in);
				nacionalidad = scan.nextLine();

				perso = new Persona(nombre, apellido, edad, nacionalidad);

				lista.add(perso);
				System.out.println("el registro se guardo con exito");
				break;
			}
			case 2: {
				System.out.println("2 mostrar la lista");
				System.out.println("la informacion de la lista es:\n" + lista);
				break;
			}
			case 3: {
				System.out.println("3 editar");
				System.out.println("ingrese el indice para editar");
				scan = new Scanner(System.in);
				indice = scan.nextInt();

				perso = lista.get(indice);
				do {
					System.out.println("1 editar nombre");
					System.out.println("2 editar apellido");
					System.out.println("3 editar edad");
					System.out.println("4 editar nacionalidad");
					System.out.println("5 regresar al menu principal");
					System.out.println("ELIGE UNA OPCION DEL MENU");

					scan = new Scanner(System.in);
					menuSecundario = scan.nextInt();

					switch (menuSecundario) {
					case 1: {
						System.out.println("Escriba el nuevo nombre");
						scan = new Scanner(System.in);
						nombre = scan.nextLine();
						perso.setNombre(nombre);
						lista.set(indice, perso);
						System.out.println("se edito correctamente");
						break;
					}
					case 2: {
						System.out.println("Escriba el nuevo apellido");
						scan = new Scanner(System.in);
						apellido = scan.nextLine();
						perso.setApellido(apellido);
						lista.set(indice, perso);
						System.out.println("se edito correctamente");
						break;
					}
					case 3: {
						System.out.println("Escriba la nueva edad");
						scan = new Scanner(System.in);
						edad = scan.nextInt();
						perso.setEdad(edad);
						lista.set(indice, perso);
						System.out.println("se edito correctamente");
						break;
					}
					case 4: {
						System.out.println("Escriba la nueva nacionalidad");
						scan = new Scanner(System.in);
						nacionalidad = scan.nextLine();
						perso.setNacionalidad(nacionalidad);
						lista.set(indice, perso);
						System.out.println("se edito correctamente");
						break;
					}
					case 5: {
						System.out.println("Saliendo del menu de edición...");
						break;
					}
					default:
						System.out.println("opcion invalida intente con un indice dentro del menu");
						break;
					}
				} while (menuSecundario != 5);
				break;
			}
			case 4: {
				System.out.println("4 .- Buscar un elemento en la lista");
				System.out.println("Cual es el indice que desea buscar?");
				scan = new Scanner(System.in);
				indice = scan.nextInt();
				perso = lista.get(indice);
				System.out.println("Elemento encontrado: \n" + perso);
				break;
			}
			case 5: {
				System.out.println("5 .- eliminar un registro");
				System.out.println("que indice desea eliminar?");
				scan = new Scanner(System.in);
				indice = scan.nextInt();
				lista.remove(indice);
				System.out.println("Elemento eliminado\nLista actualizada\n" + lista);
				break;
			}
			case 6: {
				System.out.println("6 contando los elementos de la lista");
				System.out.println("existen " + lista.size() + " personas registradas");
				break;
			}
			case 7: {
				System.out.println("saliendo del menu vuelva pronto");
				break;
			}
			default:
				System.out.println("operacion invalida intente con un valor valido");
				break;
			}
		} while (menuPrincipal != 7);
	}
}

