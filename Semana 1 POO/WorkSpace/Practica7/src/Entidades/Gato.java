package Entidades;

public class Gato extends Animal{

	private String maullido;
	
	//metodo personalizado
			public String mostrarDatos() {
				return "Animal\n" + "nombre" +this.nombre + "\nEspecie" + this.especie + "\nEdad" + this.edad +
						"\nSonido que emite " + this.maullido;
			}
			
			public Gato() {
				
			}

			public Gato(String nombre, String especie, int edad, String maullido) {
				super(nombre, especie, edad);
				this.maullido = maullido;
			}

			public String getMaullido() {
				return maullido;
			}

			public void setMaullido(String maullido) {
				this.maullido = maullido;
			}

			@Override
			public String toString() {
				return "Gato [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", maullido=" + maullido
						+ "]";
			}
			
			
			
			
}
