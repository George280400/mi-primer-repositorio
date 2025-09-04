package Principal;
import Entidades.Primaria;
import Entidades.Universidad;

public class Principal {

	public static void main(String[] args) {

		System.out.println("M A E S T R O   P R I M A R I A");
		Primaria p1 = new Primaria("Nayeli", "Hernandez", 25, 5, "Primaria", "Ciencias Naturales", 300.00);
		System.out.println(p1);
		p1.trabajar();
		p1.cobrar(p1.getNivel(), p1.getGrado());
		
		

		System.out.println("M A E S T R O   U NI V E R S I D A D");
		Universidad u1 = new Universidad("Armando", "Cuevas", 29, 7, "Universidad", "Calculo Vectorial", 700.00);
		System.out.println(u1);
		u1.trabajar();
		u1.cobrar(u1.getNivel(), u1.getGrado());

	}

}
