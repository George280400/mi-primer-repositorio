package com.mx.Proveedor.TemplateConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //nos esta definiendo que esta clase contiene una configuracion para la aplicacion y debe definir uno o mas beans
public class RestTemplateConfig {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate(); // RestTemplate es un cliente HTTP de Spring que permite consumir servicios REST desde tu aplicación.
	}

}
