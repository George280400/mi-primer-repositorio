package com.mx.Ejercicios;

public class Reloj {

	public static void main(String[] args) {
		
		Reloj reloj = new Reloj(12, 0, 0); 

        for (int i = 0; i <= 60; i++) { // 1 - 60 segundos
            reloj.mostrarHora();        
            reloj.avanzarSegundo();  
            try {
                Thread.sleep(1000);     // pausa de un segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		

	}
	
	// atributos
    private int hora;
    private int minuto;
    private int segundo;
    
    //constructor por defecto
    
    public Reloj() {
    	
    }

    // cosntructor con parametor
    public Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    
    // metodo que avanza un segundo
    public void avanzarSegundo() {
        segundo++; 
        if (segundo == 60) {
            segundo = 0;
            minuto++;
        }
    }
        
 // metodo para mostrar la hora en horas minutos y segundos
    public void mostrarHora() {
        System.out.printf("%02d:%02d:%02d%n", hora, minuto, segundo);
    }

	
	
}
