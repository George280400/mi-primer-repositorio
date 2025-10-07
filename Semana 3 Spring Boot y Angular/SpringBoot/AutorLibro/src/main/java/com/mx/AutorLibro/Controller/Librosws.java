package com.mx.AutorLibro.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.AutorLibro.Dominio.Libros;
import com.mx.AutorLibro.Service.AutorServiceImp;
import com.mx.AutorLibro.Service.LibrosServiceImp;

@RestController
@RequestMapping("/api/autores")
public class Librosws {
	
	@Autowired
	private LibrosServiceImp service;
	
	// guardar libro para un autor
	@PostMapping("/{autorId}/libros")
	public ResponseEntity<Map<String, Object>> crearLibro(@PathVariable int autorId,@RequestBody Libros libro) {   // 

	    // Guardar libro para ese autor
	    Libros libroCreado = service.guardar(libro, autorId);

	    Map<String, Object> response = new HashMap<>();
	    response.put("mensaje", "Libro creado correctamente");
	    response.put("libro", libroCreado);

	    return ResponseEntity.ok(response);
	}
	
	//obtener los libros de un autor
	@GetMapping("/{autorId}/libros")
	public List<Libros> obtenerLibrosPorAutor(@PathVariable int autorId) {
	    return service.obtenerLibrosPorAutor(autorId);
	}

}
