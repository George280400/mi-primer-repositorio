package com.mx.AutorLibro.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.AutorLibro.Dominio.Autor;
import com.mx.AutorLibro.Service.AutorServiceImp;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/autor")
public class Autorws {
	
	@Autowired
	private AutorServiceImp service;
	
	//guardar autor
	@PostMapping(value = "guardar")
	public ResponseEntity<Map<String, Object>> guardar(@Valid @RequestBody Autor autor) {
		
	    Autor autorGuardado = service.guardar(autor); //se guarda el autor

	    Map<String, Object> response = new HashMap<>();
	    response.put("mensaje", "Autor guardado exitosamente");
	    response.put("autor", autorGuardado);

	    return ResponseEntity.ok(response);
	}
	
	//buscar autor por id
	 @GetMapping("/buscar")
	    public ResponseEntity<Map<String, Object>> buscarAutorPorId(@RequestParam int idAutor) {
		 
	        Autor autor = service.buscar(idAutor); //se busca el autor por el id

	        Map<String, Object> response = new HashMap<>();
	        response.put("mensaje", "Autor encontrado correctamente");
	        response.put("autor", autor);

	        return ResponseEntity.ok(response);
	    }

}
