package com.mx.UsuariosRoles.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.UsuariosRoles.Dominio.Usuario;
import com.mx.UsuariosRoles.Service.UsuarioServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
@Validated
public class Usuariows {
	
	@Autowired
	private UsuarioServiceImp service;
	
	@GetMapping("listar")
	public List<Usuario> listar()
	{
		return service.listar();
	}
	
	// guardar
	@PostMapping("guardar")
    public ResponseEntity<?> guardar(@Valid @RequestBody Usuario usuario) {
        try {
            service.guardar(usuario);
            return ResponseEntity.ok("Usuario guardado correctamente");
        } catch (RuntimeException e) {
        	 return ResponseEntity.badRequest().body(Map.of("mensaje", e.getMessage()));
        }
    }
		
		@GetMapping("buscar/{id}")
		public Usuario buscar(@PathVariable("id") int idUsuario) {
		    return service.buscar(idUsuario);
		}
		
		@DeleteMapping("eliminar")
	    public ResponseEntity<String> eliminar(@RequestParam int idUsuario) {
	        service.eliminar(idUsuario);
	        return ResponseEntity.ok("Usuario eliminado correctamente");
	    }
		
		// editar
		@PutMapping("editar")
	    public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario) {
	        try {
	            service.editar(usuario);
	            return ResponseEntity.ok("Usuario editado correctamente");
	        } catch (RuntimeException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }

}
