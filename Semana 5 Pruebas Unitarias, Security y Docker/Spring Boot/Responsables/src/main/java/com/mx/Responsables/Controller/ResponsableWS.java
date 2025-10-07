package com.mx.Responsables.Controller;

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

import com.mx.Responsables.DTOs.ResponsableResponseDTO;
import com.mx.Responsables.Entity.Responsables;
import com.mx.Responsables.Service.ResponsableServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/R")
public class ResponsableWS {
	
	@Autowired
	private ResponsableServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Responsables> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay registros en la base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@Valid @RequestBody Responsables responsable) {
			service.guardar(responsable);
			return ResponseEntity.ok("El registro: " + responsable.getNombre() + " se registro con exito");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@Valid @RequestBody Responsables responsable) {
			service.editar(responsable);
			return ResponseEntity.ok("Edicion exitosa");
	}
	
	@GetMapping("/{idResponsable}")
	public ResponseEntity<?> buscar(@PathVariable int idResponsable) {
		Responsables encontrado = service.buscar(idResponsable);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El registro no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@DeleteMapping("/{idResponsable}")
	public ResponseEntity<?> eliminar(@PathVariable int idResponsable) {
		Responsables encontrado = service.buscar(idResponsable);
		if (encontrado != null) {
			service.eliminar(idResponsable);
			return ResponseEntity.ok("El registro se elimino con exito");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/responsablesFull")
    public ResponseEntity<?> listarFull() {
        List<ResponsableResponseDTO> lista = service.listarTodasResponsables();

        if (lista.isEmpty()) {
            return ResponseEntity.badRequest().body("No hay registros en la base de datos");
        } else {
            return ResponseEntity.ok(lista);
        }
    }

}
