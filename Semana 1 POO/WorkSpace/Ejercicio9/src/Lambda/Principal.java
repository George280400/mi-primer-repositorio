package Lambda;

import java.util.ArrayList;
import java.util.List;

import Entidad.Alumno;

public class Principal {

	public static void main(String[] args) {

		// instanciar

		Alumno al1 = new Alumno(7891, "Marian", "Gomez", "Ruiz", 22, "Lic en Medicina", "BUAP");
		Alumno al2 = new Alumno(4523, "Belen", "paz", "diaz", 21, "Lic. Psicologia", "BuAp");
		Alumno al3 = new Alumno(89562, "Armando", "Cuevas", "Guzman", 25, "Lic en Ofimatica", "UTT");
		Alumno al4 = new Alumno(4937, "Juan", "Pérez", "López", 20, "Ing. Computacional", "UNAM");
		Alumno al5 = new Alumno(78524, "sergio", "cova", "camargo", 33, "pili", "ITT");
		Alumno al6 = new Alumno(8923, "Mariel", "zarate", "Sanchez", 21, "Administracion", "IEU");

		List<Alumno> alu = new ArrayList<Alumno>();

		alu.add(al1);
		alu.add(al2);
		alu.add(al3);
		alu.add(al4);
		alu.add(al5);
		alu.add(al6);

		// sintaxis lambda

		// metodo que recorre cada elemento de la lista
		// por cada alumno que encuentre me imprimira el mensaje que declare en la
		// funcion lambda
		alu.forEach(alumno -> System.out.println("Nombre del alumno: " + alumno.getNombre()));
		System.out.println("   ");

		// metodo para imprimir informacion especifica pero aplicando filtro
		alu.stream().filter(alunmo -> "buap".equalsIgnoreCase(alunmo.getUniversidad()))
				.forEach(alumno -> System.out
						.println("Nombre " + alumno.getNombre() + alumno.getaPaterno() + " estudia la carrera de "
								+ alumno.getCarrera() + " en la universidad " + alumno.getUniversidad()));
		System.out.println("   ");

		// expresiones lambda con interfaces funcionales

		ISaludo mensaje = (saludo, despedida) -> saludo + " y " + despedida;
		System.out.println("Expresiones lambda con 2 Parametros\n"
				+ mensaje.saludar("Hola con Expresiones lambda", "Hasta luego"));
		System.out.println("   ");

		// Filtar los alumnos que tengan una edad mayor a 22 años
		alu.stream().filter(alumno -> alumno.getEdad() > 22)
				.forEach(alumno -> System.out.println(
						"Nombre: " + alumno.getNombre() + " " + alumno.getaPaterno() + " Edad: " + alumno.getEdad()
								+ " Carrera: " + alumno.getCarrera() + " Universidad: " + alumno.getUniversidad()));
		System.out.println("   ");

		// Filtar los alumnos cuyo nombre comienza con la letra "A"
		alu.stream().filter(alumno -> alumno.getNombre().startsWith("A"))
				.forEach(alumno -> System.out.println(
						"Nombre: " + alumno.getNombre() + " " + alumno.getaPaterno() + " Edad: " + alumno.getEdad()
								+ " Carrera: " + alumno.getCarrera() + " Universidad: " + alumno.getUniversidad()));
		System.out.println("   ");

		// ordenar los alumnos por su nombre
		alu.stream().sorted((a1, a2) -> a1.getNombre().compareToIgnoreCase(a2.getNombre()))
				.forEach(alumno -> System.out.println(
						"Nombre: " + alumno.getNombre() + " " + alumno.getaPaterno() + " Edad: " + alumno.getEdad()
								+ " Carrera: " + alumno.getCarrera() + " Universidad: " + alumno.getUniversidad()));
		System.out.println("   ");

		// Contar los alumnos de la carrera de Medicina
		int cantidad = (int) alu.stream().filter(alumno -> "Lic en Medicina".equalsIgnoreCase(alumno.getCarrera()))
				.count();
		System.out.println("Número de alumnos de Medicina: " + cantidad);
		System.out.println("   ");

		// calcular el promedio de las edade de todos los alumnos
		double promedio = alu.stream().mapToInt(Alumno::getEdad).average().orElse(0);
		System.out.println("El promedio de edad de los alumnos es: " + promedio);
		System.out.println("   ");

		// verificar si axite un alumno en la carrera de Ing. Sofware
		boolean existe = alu.stream().anyMatch(alumno -> "Ing. Software".equalsIgnoreCase(alumno.getCarrera()));
		if (existe) {
			System.out.println("Sí existe un alumno en la carrera de Ing Software");
		} else {
			System.out.println("No existe ningún alumno en la carrera de Ing Software");
		}
		System.out.println("   ");

		// filtar alumnos por univeridad "buap" y la cerrara de "lic.Psicologia.
		alu.stream()
				.filter(alumno -> "BUAP".equalsIgnoreCase(alumno.getUniversidad())
						&& "Lic. Psicologia".equalsIgnoreCase(alumno.getCarrera()))
				.forEach(alumno -> System.out.println(
						"Nombre: " + alumno.getNombre() + " " + alumno.getaPaterno() + " Edad: " + alumno.getEdad()
								+ " Carrera: " + alumno.getCarrera() + " Universidad: " + alumno.getUniversidad()));

	}

}
