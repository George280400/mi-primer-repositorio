package Entidades;

public class Perro  extends Animal{
	
	private String sonido;
	
	//metodo personalizado
		public String mostrarDatos() {
			return "Animal\n" + "nombre" +this.nombre + "\nEspecie" + this.especie + "\nEdad" + this.edad +
					"\nSonido que emite " + this.sonido;
		}
		
		public Perro() {
			
		}

		public Perro(String nombre, String especie, int edad, String sonido) {
			super(nombre, especie, edad);
			this.sonido = sonido;
		}

		public String getSonido() {
			return sonido;
		}

		public void setSonido(String sonido) {
			this.sonido = sonido;
		}

		@Override
		public String toString() {
			return "Perro [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", sonido=" + sonido + "]";
		}
		
		

}
