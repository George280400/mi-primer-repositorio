package com.mx.Proveedor.Controller;

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
import com.mx.Proveedor.Entity.Proveedor;
import com.mx.Proveedor.Service.ProveedorServiceImp;

@RestController
@RequestMapping(path = "/Proveedor")
public class ProveedorWS {
	
	@Autowired
	private ProveedorServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Proveedor> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.ofNullable("no existen registros en esta base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Proveedor proveedor) {
			service.guardar(proveedor);
			return ResponseEntity.ok("El registro: " + proveedor.getNombre() + " se registro con exito");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Proveedor proveedor) {
			service.editar(proveedor);
			return ResponseEntity.ok("Edicion exitosa");
	}
	
	@GetMapping("/{idProveedor}")
	public ResponseEntity<?> buscar(@PathVariable int idProveedor) {
		Proveedor encontrado = service.buscar(idProveedor);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El registro no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@DeleteMapping("/{idProveedor}")
	public ResponseEntity<?> eliminar(@PathVariable int idProveedor) {
		Proveedor encontrado = service.buscar(idProveedor);
		if (encontrado != null) {
			service.eliminar(idProveedor);
			return ResponseEntity.ok("El registro se elimino con exito");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("productos/{proveedorId}")
	public ResponseEntity<?> obtenerProductos(@PathVariable int proveedorId){
		return ResponseEntity.ok(service.obtenerProveedorConProductos(proveedorId));
	}
	
	

}
