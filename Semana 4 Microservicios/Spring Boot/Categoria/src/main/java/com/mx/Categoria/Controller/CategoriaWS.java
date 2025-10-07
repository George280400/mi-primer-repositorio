package com.mx.Categoria.Controller;

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

import com.mx.Categoria.Entity.Categoria;
import com.mx.Categoria.Service.CategoriaService;


@RestController
@RequestMapping(path = "/C")
public class CategoriaWS {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Categoria> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.ofNullable("no existen registros en esta base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Categoria categoria) {
			service.guardar(categoria);
			return ResponseEntity.ok("El registro: " + categoria.getNombre() + " se registro con exito");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Categoria categoria) {
			service.editar(categoria);
			return ResponseEntity.ok("Edicion exitosa");
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<?> buscar(@PathVariable int idCategoria) {
		Categoria encontrado = service.buscar(idCategoria);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El registro no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@DeleteMapping("/{idCategoria}")
	public ResponseEntity<?> eliminar(@PathVariable int idCategoria) {
		Categoria eliminado = service.buscar(idCategoria);
		if (eliminado != null) {
			service.eliminar(idCategoria);
			return ResponseEntity.ok("El registro se elimino con exito");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("productos/{categoriaId}")
	public ResponseEntity<?> obtenerProductos(@PathVariable int categoriaId){
		return ResponseEntity.ok(service.obtenerCategoriaConProductos(categoriaId));
	}

}
