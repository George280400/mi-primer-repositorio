package com.mx.Ejercicios;

import java.util.Scanner;

public class TablasMultiplicar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

        // se pide el numero
        System.out.print("Introduce un numero: ");
        int N = scanner.nextInt();

        System.out.println("\nTabla de multiplicar del " + N + ":");

        // se genera la tabla del 1 al 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i + " = " + (N * i));
        }

	}

}
