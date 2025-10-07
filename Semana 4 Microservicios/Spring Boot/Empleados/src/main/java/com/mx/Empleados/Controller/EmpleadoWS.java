package com.mx.Empleados.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mx.Empleados.Entity.Empleado;
import com.mx.Empleados.Service.EmpleadoServiceImp;

@RestController
@RequestMapping(path = "/E")
public class EmpleadoWS {
	
	@Autowired
	private EmpleadoServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Empleado> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.badRequest().body("no existen registros en esta base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Empleado empleado){
	    if(service.existeTelefono(empleado.getTelefono())) {
	        return ResponseEntity.badRequest().body("Este numero de telefono ya esta registrado");
	    }
	    if(service.existeEmpleado(empleado.getNombre(), empleado.getApellido())) {
	        return ResponseEntity.status(HttpStatus.FOUND).body("El empleado: " + empleado.getNombre() + " " + empleado.getApellido() +
	                " ya esta registrado en la base de datos");
	    }
	    service.guardar(empleado);
	    return ResponseEntity.ok("Registro del empleado " + empleado.getNombre() + " exitoso");
	}
	
	@GetMapping("/{idEmpleado}")
	public ResponseEntity<?> buscar(@PathVariable int idEmpleado) {
		Empleado encontrado = service.buscar(idEmpleado);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El registro no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Empleado empleado) {
			service.editar(empleado);
			return ResponseEntity.ok("Edicion exitosa");
	}
	
	@DeleteMapping("/{idEmpleado}")
	public ResponseEntity<?> eliminar(@PathVariable int idEmpleado) {
		Empleado eliminado = service.buscar(idEmpleado);
		if (eliminado != null) {
			service.eliminar(idEmpleado);
			return ResponseEntity.ok("El registro se elimino con exito");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
