package com.mx.Ejercicios;

import java.util.Scanner;

public class NumerosPrimos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

        // pedir numero al suario
        System.out.print("Introduce un numero: "); //numero primo es un numero mayor a 1  
        int N = scanner.nextInt();                 //que solo tiene dos divisores postivos el 1 y por si mimo

        boolean esPrimo = true;

        if (N <= 1) {
            esPrimo = false;
        } else {
            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    esPrimo = false;
                    break; // si encuentra un divisor ya no es primo
                }
            }
        }

        if (esPrimo) {
            System.out.println(N + " es un numero primo.");
        } else {
            System.out.println(N + " no es un numero primo.");
        }

	}

}
