package com.mx.Carro;

public class Carro {
	

	//declaracion de atributos: son las variables que representan el estado del objeto
		private String marca;
		private String modelo;
		private String tipo;
		private String color;
		
		//declaracion de los metodos :son las funciones que describen el comportamiento de los objetos
		
		//constructor por defecto (default) o conocido como vacio: inicializa el objeto
		
		public Carro() {
			
		}
		
		//constructor parametrizado: inicializa el objeto con los parametros (atributos) especificos
		
		public Carro(String marca, String modelo, String tipo, String color) {
			this.marca = marca;
			this.modelo = modelo;
			this.tipo = tipo;
			this.color = color;
		}
		
		//metodos get y set: en algun momento yo voy a querer acceder a los atributos pero al ser declarados en private no se pueden acceder desde otra clase
		//Get: permiten obtener el valor del atributo
		
		public String getMarca() {
			return marca;
		}
		
		//set: permite modificar el valor del atributo con validaciones
		//void es un tipo de valor de retorno pero no devuelve ningun valor
		public void setMarca(String marca)
		{
			this.marca = marca;
		}
		
		public String getModelo() {
			return modelo;
		}
		
		public void setModelo(String modelo)
		{
			this.modelo = modelo;
		}
		
		public String getTipo() {
			return tipo;
		}
		
		public void setTipo(String tipo)
		{
			this.tipo = tipo;
		}
		
		public String getColor() {
			return color;
		}
		
		public void setColor(String color)
		{
			this.color = color;
		}
		
		//metodo toString : va a convertir los atributos legibles para que puedan ser impresos en consola
		
		public String toString() {
		    return "Carro [marca=" + marca 
		           + ", modelo=" + modelo 
		           + ", tipo=" + tipo 
		           + ", color=" + color + "]\n";
		}

}
