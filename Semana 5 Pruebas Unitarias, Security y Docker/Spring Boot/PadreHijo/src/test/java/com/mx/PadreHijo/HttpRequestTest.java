package com.mx.PadreHijo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//indica el servidor spring en un puerto aleatorio para evitar conflicto
//esta anotacion crea un contexto de prueba completo para la aplicacion
public class HttpRequestTest {
	
	@LocalServerPort //inyecte el puerto asignado cuando se construya el url
	private int port;
	
	@Autowired
	TestRestTemplate restTemplate; //nos va a permitir enviar solicitudes http simuladas y obtener respuestas
	
	@Test
	void pruebaControllerMensajePredeterminado() throws Exception{
		
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Hola, Mundo");
		
	}

}
