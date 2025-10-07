package com.mx.Emisor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mx.Emisor.DTOs.ClienteDTO;

@RestController
@RequestMapping("/enviar-cliente")
public class EmisorController {
	
	@Autowired
    private RestTemplate restTemplate; //inyeccion de rest template

	@PostMapping
	public ResponseEntity<String> enviarCliente(@RequestBody ClienteDTO cliente) {
	    String url = "http://localhost:8081/procesar-cliente"; //url del receptor que va a procesar el cliente
	    try {
	        ResponseEntity<String> response = restTemplate.postForEntity(url, cliente, String.class); //se hace la peticion POST con el rest template
	        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	    } catch (org.springframework.web.client.HttpClientErrorException e) {
	    	
	        // Solo se devuelve el mensaje que envio el receptor
	        return ResponseEntity.status(e.getStatusCode())
	                             .body(e.getResponseBodyAsString().replaceAll("\"", ""));
	    } catch (Exception e) {
	        return ResponseEntity.status(500).body("Error interno: " + e.getMessage());
	    }
	}

}
