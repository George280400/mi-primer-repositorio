package com.mx.Ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class OrdenarNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[5]; // array para guardar 5 n umeros

        // pedir los numeros al usuasio
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce el numero " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // ordenar el array desc
        Arrays.sort(numeros);

        // se muestran los numeros ordenados
        System.out.println("\nNumeros en orden ascendente:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

	}

}
