package Entidades;

public class Loro extends Animal{
	
	private String silvido;
	
	//metodo personalizado
		public String mostrarDatos() {
			return "Animal\n" + "nombre" +this.nombre + "\nEspecie" + this.especie + "\nEdad" + this.edad +
					"\nSonido que emite " + this.silvido;
		}
		
		public Loro() {
			
		}

		public Loro(String nombre, String especie, int edad, String silvido) {
			super(nombre, especie, edad);
			this.silvido = silvido;
		}

		public String getSilvido() {
			return silvido;
		}

		public void setSilvido(String silvido) {
			this.silvido = silvido;
		}

		@Override
		public String toString() {
			return "Loro [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", silvido=" + silvido + "]";
		}
		
		

}
