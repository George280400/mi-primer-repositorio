package com.mx.Ejercicios;

import java.util.Scanner;

public class ParesImpares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

        // Pedimos al usuario un número entero
        System.out.print("Introduce un numero ");
        int N = scanner.nextInt();

        int pares = 0;
        int impares = 0;

        System.out.println("\nNimeros del 1 al " + N + ":");

        // recorre los numeros del na al ingresado
        for (int i = 1; i <= N; i++) {
            System.out.print(i + " ");
            if (i % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        
        System.out.println("\n\nResultados:");
        System.out.println("Cantidad de numeros pares: " + pares);
        System.out.println("Cantidad de numeros impares: " + impares);


	}

}
