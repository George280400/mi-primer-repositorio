package EstadisticosyConstantes;

public class Principal {
	
	//miembro estatico: metodos o atributos que se asocian a una clase en lugar de una inatncia
	//miembro constante: son variables que se declaran con la plabra clave final y su valor nunca cambia durante la ejecucion
	
	//mienbro estatico
	
	public static String frase1 = "Mienbro Estatico";
	
	//constante o variable final
	
	public final String frase2 = "Variable final constante";
	
	// constante estatica: No cambia despues de su inicializacion
	
	public static final String frase3 = "Variable final estatica";
	
	public static void main(String[]args) {
		// acceso a mis mienbros estaticos asociados a mi clase
		 System.out.println(frase1);
		 System.out.println(frase3);
		 
		 //ejemplo del area del circulo
		 
		 float radio = 5;
		 double area = calcularAreaCirculo(radio);
		 
		 System.out.println("El area del circulo con radio " + radio + "es " + area);
		 
	}
	
	//metodo que calcule el area de un circulo mediante un metodo estatico
	 private static double calcularAreaCirculo(float radio) {
		 
		 return Math.PI * (radio * radio);
		 
	 }

}
