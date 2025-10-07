package com.mx.Ejercicios;

import java.util.Random;
import java.util.Scanner;

public class adivinaNumero {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1; 
        int intentos = 0;
        int numero;

        System.out.println("adivina el numero entre el 1 y 100 tienes 10 intentos");

        while (intentos < 10) {
            System.out.print("Intento " + (intentos + 1) + ": ");
            numero = scanner.nextInt();
            intentos++;

            if (numero == numeroSecreto) {
                System.out.println("felicidades lo adivinas en " + intentos + " intentos");
                return; 
            } else if (numero < numeroSecreto) {
                System.out.println("El numero es mayor.");
            } else {
                System.out.println("El numero es menor.");
            }
        }

        System.out.println("se acabaron los intentos, el numero era " + numeroSecreto);

	}

}
