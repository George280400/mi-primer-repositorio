package Principal;

import Entidades.Medico;
import Entidades.Abogado;

public class Principal {

	public static void main(String[] args) {
		
		Medico medico = new Medico("Mariano", "Ventura", 32, 7841259, "UNAM", 5, "Medico General", "Farmacia del ahorro", 5000);
		System.out.println(medico);
		medico.trabajar();
		medico.cobrar(medico.getEspecialidad(), medico.getCostoCosulta());
		
		System.out.println("-----ABOGADO-----");
		
		Abogado abogado = new Abogado("Liliana", "Gutierrez", 29, 12478, "BUAP", 4, "Familiar", "DIF", 1900);
		System.out.println(abogado);
		abogado.trabajar();
		abogado.cobrar(abogado.getTipo(), abogado.getHonorarios());

	}

}
