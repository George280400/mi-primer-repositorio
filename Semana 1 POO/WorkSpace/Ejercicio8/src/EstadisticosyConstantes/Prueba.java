package EstadisticosyConstantes;

public class Prueba {

	public static void main(String[] args) {
		
		//instanciar
		
		Principal obj1 = new Principal();
		
        // acceder a los miembros
		System.out.println("obj1 " + obj1.frase2); //miembro de instancia
		
		System.out.println("ob2 " + Principal.frase1); //mienbro a travez de una clase
	}

}
