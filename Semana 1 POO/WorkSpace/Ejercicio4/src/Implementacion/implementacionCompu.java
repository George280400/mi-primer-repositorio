package Implementacion;
//la palabra reservada "extends" para traer los metodos que tengo declarados en la implmentacion genereica
//hace que yo pueda utilizar tanto los metodos como los atributos de la superclase que estoy refiriendo
public class implementacionCompu extends ImplementacionGenerica{
	
	//metodo personalizado contar
	
	public void contar() {
		System.out.println("Existen " + hash.size() + "computadoras registradas");
	}

}
