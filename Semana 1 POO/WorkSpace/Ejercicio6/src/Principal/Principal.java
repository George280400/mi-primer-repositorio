package Principal;

import com.mx.Entidades.Computadora;

import Implementacion.implementacionCompu;

public class Principal {

	public static void main(String[] args) {
		//se instancia la primera clase
		
		Computadora c1 = new Computadora(3541, "Dell", "Intel Core I7 12th", 16, "500gb", "Negro");
		Computadora c2 = new Computadora(5841, "Hp", "AMD Ryzen 5", 8, "1Tb", "azul");
		Computadora c3 = new Computadora(7845, "Toshiba", "Celeron", 4, "1TB", "morado");
		
		//Objeto auxiliar
		Computadora compu = null;
		
		//implementacion
		 implementacionCompu impC = new implementacionCompu();
		 impC.guardar(c1.getSku(), c1);
		 impC.guardar(c2.getSku(), c2);
		 impC.guardar(c3.getSku(), c3);
		 
		 impC.mostrar();
		 
		 
		 //buscar
		 // Casteo: cambio de datos
		 compu = (Computadora) impC.buscar(c1.getSku());
		 System.out.println(compu);
		 
		 //eliminar
		 impC.eliminar(c1.getSku());
		 impC.mostrar();
		 
		 //contar
		 impC.contar();
		

	}

}
