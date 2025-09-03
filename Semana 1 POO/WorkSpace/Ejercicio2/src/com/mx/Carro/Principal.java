package com.mx.Carro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;





public class Principal {
	
	//metodo que hace que compile el programa
		public static void main(String[]args) {
			
			//instanciar el objeto (crear el objeto con los metodos declarados en mi clase persona)
			//se manda a llamar al clase para darle el valor de esa clase a una variable
			//utilizo la palabra reservada new, que manda a traer a mi constructor
			Carro carro1 = new Carro("Volskwagen", "Jetta", "Gasolina", "Rojo");
			Carro carro2 = new Carro("Nissan", "tsuru", "gasolina", "azul");
			Carro carro3 = new Carro("Toyota", "corolla", "gasolina", "verde");
			Carro carro4 = new Carro("Chevrolet", "spark", "gasolina", "blanco");
			Carro carro5 = new Carro("dodge", "neon", "diesel", "negro");
			
			//crear una lista para almacenar los objetos
			//lista es una estructura de datos
			//List<Persona> lista = new ArrayList<Persona>();
			
			List<Carro> lista = new ArrayList<Carro>();
			
			//agregar los objetos a la lista
			lista.add(carro1);
			lista.add(carro2);
			lista.add(carro3);
			lista.add(carro4);
			lista.add(carro5);
			//mostrar el contenido de la lista
			/*
			 * System.out.println(lista);
			 * 
			 * //crear un auxiliar Carro car = null; car = lista.get(0);
			 * System.out.println(car);
			 * 
			 * //editar un objeto car = lista.get(2); car.setMarca("cambio");
			 * car.setTipo("cambio"); System.out.println(car);
			 * 
			 * //eliminar un objeto de la lista lista.remove(4);
			 * System.out.println("lista actualizada\n" + lista);
			 * 
			 * //contar elementos en la lista System.out.println("Existen:" + lista.size() +
			 * "carros guardados"); // limpiar la lista lista.clear();
			 * 
			 * //validar si la lista esta vacia
			 * 
			 * if(lista.isEmpty()) { System.out.println("la lista esta vacia"); }else {
			 * System.out.println("esta es la lista\n" + lista); }
			 */
			Carro car = null;
			
			Scanner scan = null;

			int menuPrincipal = 0, menuSecundario = 0, indice = 0;

			// variables locales
			String marca, modelo, tipo, color;


			do {
				System.out.println("---MENU---");
				System.out.println("1 agregar elemento");
				System.out.println("2 mostrar la lista");
				System.out.println("3 editar");
				System.out.println("4 buscar por atributo MARCA");    //por modelo
				System.out.println("5 eliminar por atributo MARCA");  // por modelo
				System.out.println("6 contar elementos de la lista");
				System.out.println("7 eliminar todo de la lista");
				System.out.println("8 salir del menu");
				System.out.println("--- ELIGE UNA OPCION DENTRO DEL MENU---");

				scan = new Scanner(System.in);
				menuPrincipal = scan.nextInt();

				switch (menuPrincipal) {
				/*
				 * case 1: { System.out.println("1 agregar un nuevo registro");
				 * System.out.println("escriba la marca del carro"); scan = new
				 * Scanner(System.in); marca = scan.nextLine();
				 * 
				 * System.out.println("escriba el modelo del carro"); scan = new
				 * Scanner(System.in); modelo = scan.nextLine();
				 * 
				 * System.out.println("escriba el tipo de motor"); scan = new
				 * Scanner(System.in); tipo = scan.nextLine();
				 * 
				 * 
				 * System.out.println("escriba el color del carro"); scan = new
				 * Scanner(System.in); color = scan.nextLine();
				 * 
				 * car = new Carro(marca, modelo, tipo, color);
				 * 
				 * lista.add(car); System.out.println("el registro se guardo con exito"); break;
				 * }
				 */case 1: {
					    System.out.println("1 .- Agregar un nuevo registro");

					    System.out.println("Escriba la marca del carro");
					    scan.nextLine(); // limpiar buffer si antes usaste nextInt
					    marca = scan.nextLine();

					    // Validar si ya existe esa marca
					    boolean existe = false;
					    for (Carro c : lista) {
					        if (c.getMarca().equalsIgnoreCase(marca)) {
					            existe = true;
					            break;
					        }
					    }

					    if (existe) {
					        System.out.println("Ya existe un carro con la marca '" + marca + "'. Ingrese una marca diferente.");
					    } else {
					        System.out.println("Escriba el modelo del carro");
					        modelo = scan.nextLine();

					        System.out.println("Escriba el tipo de motor");
					        tipo = scan.nextLine();

					        System.out.println("Escriba el color del carro");
					        color = scan.nextLine();

					        car = new Carro(marca, modelo, tipo, color);
					        lista.add(car);
					        System.out.println("El registro se guardó con éxito");
					    }
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

					car = lista.get(indice);
					do {
						System.out.println("1 editar marca");
						System.out.println("2 editar modelo");
						System.out.println("3 editar tipo");
						System.out.println("4 editar color");
						System.out.println("5 regresar al menu principal");
						System.out.println("ELIGE UNA OPCION DEL MENU");

						scan = new Scanner(System.in);
						menuSecundario = scan.nextInt();

						switch (menuSecundario) {
						case 1: {
							System.out.println("Escriba la nueva marca");
							scan = new Scanner(System.in);
							marca = scan.nextLine();
							car.setMarca(marca);
							lista.set(indice, car);
							System.out.println("se edito correctamente");
							break;
						}
						case 2: {
							System.out.println("Escriba el nuevo modelo");
							scan = new Scanner(System.in);
							modelo = scan.nextLine();
							car.setModelo(modelo);
							lista.set(indice, car);
							System.out.println("se edito correctamente");
							break;
						}
						case 3: {
							System.out.println("Escriba el nuevo tipo");
							scan = new Scanner(System.in);
							tipo = scan.nextLine();
							car.setTipo(tipo);
							lista.set(indice, car);
							System.out.println("se edito correctamente");
							break;
						}
						case 4: {
							System.out.println("Escriba el nuevo color");
							scan = new Scanner(System.in);
							color = scan.nextLine();
							car.setColor(color);
							lista.set(indice, car);
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
				/*
				 * case 4: { System.out.println("4 .- Buscar un elemento en la lista");
				 * System.out.println("Cual es el indice que desea buscar?"); scan = new
				 * Scanner(System.in); indice = scan.nextInt(); perso = lista.get(indice);
				 * System.out.println("Elemento encontrado: \n" + perso); break; }
				 */
				case 4: {
				    System.out.println("4 .- Buscar un carro por marca");
				    System.out.println("¿Cuál es la marca que desea buscar?");
				    scan = new Scanner(System.in);
				    String marcaBuscada = scan.nextLine();

				    boolean encontrado = false;
				    for (Carro c : lista) {
				        if (c.getMarca().equalsIgnoreCase(marcaBuscada)) {
				            System.out.println("Elemento encontrado: \n" + c);
				            encontrado = true;
				        }
				    }

				    if (!encontrado) {
				        System.out.println("No se encontró ningún carro con la marca: " + marcaBuscada);
				    }
				    break;
				}
				/*
				 * case 5: { System.out.println("5 .- eliminar un registro");
				 * System.out.println("que marca desea eliminar?"); scan = new
				 * Scanner(System.in); indice = scan.nextInt(); lista.remove(indice);
				 * System.out.println("Elemento eliminado\nLista actualizada\n" + lista); break;
				 * }
				 */
				case 5: {
				    System.out.println("5 .- Eliminar un carro por marca");
				    System.out.println("¿Qué marca desea eliminar?");
				    scan = new Scanner(System.in);
				    String marcaEliminar = scan.nextLine();

				    boolean eliminado = false;

				    // Usamos iterator para poder eliminar dentro del bucle
				    Iterator<Carro> it = lista.iterator();
				    while (it.hasNext()) {
				        Carro c = it.next();
				        if (c.getMarca().equalsIgnoreCase(marcaEliminar)) {
				            it.remove(); // elimina el elemento actual
				            eliminado = true;
				            System.out.println("Carro eliminado: " + c);
				            // Si solo quieres eliminar el primero encontrado, pon un break aquí
				        }
				    }

				    if (!eliminado) {
				        System.out.println("No se encontró ningún carro con la marca: " + marcaEliminar);
				    } else {
				        System.out.println("Lista actualizada:\n" + lista);
				    }
				    break;
				}
				case 6: {
					System.out.println("6 contando los elementos de la lista");
					System.out.println("existen " + lista.size() + " carros en la lista");
					break;
				}
				case 7: {
					lista.clear();
					
					if(lista.isEmpty()) { System.out.println("la lista esta vacia"); }else {
						  System.out.println("esta es la lista\n" + lista); }
					break;
				}
				default:
					System.out.println("operacion invalida intente con un valor valido");
					break;
				}
			} while (menuPrincipal != 8);
		}

}
