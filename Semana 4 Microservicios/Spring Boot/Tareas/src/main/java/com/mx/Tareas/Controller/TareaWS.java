package com.mx.Tareas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Tareas.Dominio.Tarea;
import com.mx.Tareas.Service.TareaServiceImp;

import jakarta.validation.Valid;

@RestController 
@RequestMapping(path = "api/Tareas") 
@CrossOrigin 
@Valid
public class TareaWS {
	
	@Autowired // inyeccion del servicio
	private TareaServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Tarea> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.ofNullable("no existen registros en esta base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@Valid @RequestBody Tarea tarea) {
	    service.guardar(tarea);
	    return ResponseEntity.ok("La Tarea: " + tarea.getTitulo() + " se registró con éxito");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@PathVariable int id, @Valid @RequestBody Tarea tarea) {
	    tarea.setId(id); 
	    service.editar(tarea); 
	    return ResponseEntity.ok("Edición exitosa");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
	    // Buscamos la tarea 
	    Tarea tarea = service.buscar(id);
	    
	    if (tarea == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la tarea con id: " + id);
	    }

	    return ResponseEntity.ok(tarea);
	}



}
