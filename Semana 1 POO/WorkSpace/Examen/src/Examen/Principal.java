package Examen;

public class Principal {

	private static Videojuego[] juegos;

	public static void main(String[] args) {

		// Array de 5 posiciones Series
		Serie[] serie = new Serie[5];
		serie[0] = new Serie("Breaking Bad", "Vince Gilligan");
		serie[1] = new Serie("Stranger Things", "Hermanos Duffer");
		serie[2] = new Serie("Game of Thrones", 8, "Fantasía", "George R. R. Martin");
		serie[3] = new Serie("The Office", 9, "Comedia", "Greg Daniels");
		serie[4] = new Serie("The Crown", 6, "Drama Histórico", "Peter Morgan");

		// Array de 5 posiciones Videojuegos
		Videojuego[] juego = new Videojuego[5];
		juego[0] = new Videojuego("Minecraft", 200);
		juego[1] = new Videojuego("The Witcher 3", 120);
		juego[2] = new Videojuego("Cyberpunk 2077", 300, "RPG", "CD Projekt");
		juego[3] = new Videojuego("FIFA 23", 50, "Deportes", "EA Sports");
		juego[4] = new Videojuego("Assassin's Creed Valhalla", 80, "Aventura", "Ubisoft");

		// Entregar videojuegos y series con el metodo entregar

		serie[0].entregar();
		serie[3].entregar();
		juego[1].entregar();
		juego[2].entregar();

		// Contar entregados
		int entregadasSeries = 0;
		int entregadosJuegos = 0;

		for (Serie s : serie) {
			if (s.isEntregado()) {
				entregadasSeries++;
				s.devolver(); // devolver al contarlos
			}
		}

		for (Videojuego v : juego) {
			if (v.isEntregado()) {
				entregadosJuegos++;
				v.devolver(); // devolver al contarlos
			}
		}

		//Numero de series y juegos devueltos
		System.out.println("Series entregadas: " + entregadasSeries);
		System.out.println("Videojuegos entregados: " + entregadosJuegos);
		
		//serie con mas temporadas
		Serie serieMax = serie[0];
        for (int i = 1; i < serie.length; i++) {
            if (serie[i].compareTo(serieMax) > 0) { 
                serieMax = serie[i];
            }
        }
        
        System.out.println("\nSerie con más temporadas:");
        System.out.println(serieMax.toString());
        
        //videojuego con mas horas
        Videojuego juegoMax = juego[0];
        for (int i = 1; i < juego.length; i++) {
            if (juego[i].compareTo(juegoMax) > 0) { 
                juegoMax = juego[i];
            }
        }
        
        System.out.println("\nVideojuego con más horas estimadas:");
        System.out.println(juegoMax.toString());

	}

}
