package com.mx.Categoria.TemplateConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Configuration //nos esta definiendo que esta clase contiene una configuracion para la aplicacion y debe definir uno o mas beans

public class RestTemplateConfig {
  
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate(); 
	}
	
	//RestTemplate es una clase de Spring que permite consumir servivios rest desde tu aplicacion, basicamente es un cliente
	//HTTP integrado en Spring y permite hacer llamadas a otros servicios WEB y recibir la respuesta directamente como objetos 
	//JAVA
	//en este caso nosotros vamos a enviar una peticion GET al microservicio de Producto
	//@GetMapping("buscarPorCategoria/{categoriaId}")<-- peticion a es econtrolador
	//y este servicio nos devolvera en jason la lista de productos
	//a esto se le llama comunicion sincrona entre microservicios que usan REST
	//Sincrona : el microservicio Categoria espera la respuesta del microservixcio producto antes de continuar
	//REST/HTTP -> se esta usando HTTP para solicitar informacion y los datos se transfierren en formato JSON 
	//cada microservicio sigue siendo independiente pero se comunican a travez de endpoint expuestos
}
