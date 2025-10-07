package com.mx.Ejercicios;

import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {

	public static void main(String[] args) {
		
		 PiedraPapelTijera juego = new PiedraPapelTijera();
	        juego.jugar();
	}
	
	
	// Método para jugar una partida
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Opciones disponibles
        String[] opciones = {"piedra", "papel", "tijera"};

        // Pedimos la jugada del usuario
        System.out.print("Elige tu jugada (piedra, papel, tijera): ");
        String jugadaUsuario = scanner.nextLine().toLowerCase();

        // validar jugada del usuario
        boolean valida = false;
        for (String opcion : opciones) {
            if (opcion.equals(jugadaUsuario)) {
                valida = true;
                break;
            }
        }

        if (!valida) {
            System.out.println("Jugada no válida. Intenta de nuevo.");
            return;
        }

        // la computadora elige un random
        String jugadaComputadora = opciones[random.nextInt(3)];

        System.out.println("Computadora eligió: " + jugadaComputadora);

        // elegir ganador
        if (jugadaUsuario.equals(jugadaComputadora)) {
            System.out.println("Empate");
        } else if (
            (jugadaUsuario.equals("piedra") && jugadaComputadora.equals("tijera")) ||
            (jugadaUsuario.equals("papel") && jugadaComputadora.equals("piedra")) ||
            (jugadaUsuario.equals("tijera") && jugadaComputadora.equals("papel"))
        ) {
            System.out.println("Ganaste");
        } else {
            System.out.println("Perdiste");
        }

}
}
