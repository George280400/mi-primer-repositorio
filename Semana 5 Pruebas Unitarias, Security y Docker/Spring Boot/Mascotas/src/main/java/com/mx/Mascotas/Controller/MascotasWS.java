package com.mx.Mascotas.Controller;

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

import com.mx.Mascotas.DTOs.MascotaResponse;
import com.mx.Mascotas.Entity.Mascotas;
import com.mx.Mascotas.Service.MascotaServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/M")
@Valid
public class MascotasWS {
	
	@Autowired
	private MascotaServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Mascotas> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay registros en la base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@Valid @RequestBody Mascotas mascota) {
			service.guardar(mascota);
			return ResponseEntity.ok("El registro: " + mascota.getNombre() + " se registro con exito");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@Valid @RequestBody Mascotas mascota) {
			service.editar(mascota);
			return ResponseEntity.ok("Edicion exitosa");
	}
	
	@GetMapping("/{idMascota}")
	public ResponseEntity<?> buscar(@PathVariable int idMascota) {
		Mascotas encontrado = service.buscar(idMascota);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El registro no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@DeleteMapping("/{idMascota}")
	public ResponseEntity<?> eliminar(@PathVariable int idMascota) {
		Mascotas encontrado = service.buscar(idMascota);
		if (encontrado != null) {
			service.eliminar(idMascota);
			return ResponseEntity.ok("El registro se elimino con exito");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/mascotasFull")
    public ResponseEntity<?> listarFull() {
        List<MascotaResponse> lista = service.listarTodasMascotas();

        if (lista.isEmpty()) {
            return ResponseEntity.badRequest().body("No hay registros en la base de datos");
        } else {
            return ResponseEntity.ok(lista);
        }
    }

}
