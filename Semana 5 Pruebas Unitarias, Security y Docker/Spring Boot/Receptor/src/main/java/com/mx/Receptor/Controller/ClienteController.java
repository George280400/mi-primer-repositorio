package com.mx.Receptor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Receptor.DTOs.ClienteDTO;
import com.mx.Receptor.Service.ClienteService;

@RestController
@RequestMapping("/procesar-cliente")
public class ClienteController {
	
	 @Autowired
	    private ClienteService clienteService;

	    @PostMapping
	    public ResponseEntity<String> procesarCliente(@RequestBody ClienteDTO dto) {
	        try {
	            clienteService.procesarCliente(dto);
	            return ResponseEntity.ok("Cliente procesado correctamente");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
	        }
	    }

}
