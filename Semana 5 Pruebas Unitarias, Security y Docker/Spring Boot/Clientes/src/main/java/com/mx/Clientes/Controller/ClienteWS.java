package com.mx.Clientes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Clientes.Entity.Cliente;
import com.mx.Clientes.Service.ClienteServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/C")
@Valid
public class ClienteWS {
	
	@Autowired
	private ClienteServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Cliente> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay registros en la base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@Valid @RequestBody Cliente cliente) {
			service.guardar(cliente);
			return ResponseEntity.ok("El registro: " + cliente.getNombre() + " se registro con exito");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@Valid @RequestBody Cliente cliente) {
			service.editar(cliente);
			return ResponseEntity.ok("Edicion exitosa");
	}
	
	@GetMapping("/{idCliente}")
	public ResponseEntity<?> buscar(@PathVariable int idCliente) {
		Cliente encontrado = service.buscar(idCliente);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El registro no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@DeleteMapping("/{idCliente}")
	public ResponseEntity<?> eliminar(@PathVariable int idCliente) {
		Cliente encontrado = service.buscar(idCliente);
		if (encontrado != null) {
			service.eliminar(idCliente);
			return ResponseEntity.ok("El registro se elimino con exito");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
