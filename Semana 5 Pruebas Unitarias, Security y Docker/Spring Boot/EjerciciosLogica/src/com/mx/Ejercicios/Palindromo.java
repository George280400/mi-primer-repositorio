package com.mx.Ejercicios;

import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

        // usaurio ingresa la palabra
        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();

        // se quitan espacios y lyego se pasas a minusculas
        String palabraLimpia = palabra.replaceAll("\\s+", "").toLowerCase();

        // se va a invertier la palabra
        String invertida = new StringBuilder(palabraLimpia).reverse().toString();

        // se va a comparar
        if (palabraLimpia.equals(invertida)) {
            System.out.println("Es palindromo");
        } else {
            System.out.println("No es palindromo");
        }

	}

}
