package Lambda;
@FunctionalInterface  // este anotacion especial es para indicar que es una interfaz funcional
                      //una interfaz funcional es una interface que tiene exactamente un metodo abstracto
public interface ISaludo {
	
	public String saludar(String saludo, String despedida);

}
