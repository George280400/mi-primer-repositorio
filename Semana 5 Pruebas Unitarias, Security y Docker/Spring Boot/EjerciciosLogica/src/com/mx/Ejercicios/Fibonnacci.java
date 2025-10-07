package com.mx.Ejercicios;

import java.util.Scanner;

public class Fibonnacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner scanner = new Scanner(System.in);

        // pedir al usuario cuantos numeros va a mostrar
        System.out.print("Introduce la cantidad de numeros de la serie Fibonnacci: ");
        int N = scanner.nextInt();

        int a = 0, b = 1; // los dos primeros numeros de la serie

        System.out.println("\nLos primeros " + N + " nuumeros de la serie Fibonacci:"); // F(n) = F(n-1) + F(n-2)

        for (int i = 1; i <= N; i++) {
            System.out.print(a + " ");
            int siguiente = a + b;
            a = b;
            b = siguiente;
        }
	}

}
