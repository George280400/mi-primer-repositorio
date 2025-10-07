package com.mx.Veterinarias.Controller;

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

import com.mx.Veterinarias.Entity.Veterinaria;
import com.mx.Veterinarias.Service.VeterinariaServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/V")
@Valid
public class VeterinariaWS {
	
	@Autowired
	private VeterinariaServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Veterinaria> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay registros en la base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@Valid @RequestBody Veterinaria veterinaria) {
			service.guardar(veterinaria);
			return ResponseEntity.ok("El registro: " + veterinaria.getNombre() + " se registro con exito");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@Valid @RequestBody Veterinaria veterinaria) {
			service.editar(veterinaria);
			return ResponseEntity.ok("Edicion exitosa");
	}
	
	@GetMapping("/{idVeterinaria}")
	public ResponseEntity<?> buscar(@PathVariable int idVeterinaria) {
		Veterinaria encontrado = service.buscar(idVeterinaria);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El registro no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@DeleteMapping("/{idVeterinaria}")
	public ResponseEntity<?> eliminar(@PathVariable int idVeterinaria) {
		Veterinaria encontrado = service.buscar(idVeterinaria);
		if (encontrado != null) {
			service.eliminar(idVeterinaria);
			return ResponseEntity.ok("El registro se elimino con exito");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
