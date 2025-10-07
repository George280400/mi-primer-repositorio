package com.mx.UsuariosRoles.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.UsuariosRoles.Dominio.Rol;
import com.mx.UsuariosRoles.Service.RolServiceImp;


@RestController
@RequestMapping("/api/rol")
@CrossOrigin
public class Rolws {
	@Autowired
	private RolServiceImp service;
	
	@GetMapping("listar")
	public List<Rol> listar()
	{
		return service.listar();
	}
	
	// guardar
		@PostMapping("guardar")
	    public ResponseEntity<String> guardar(@RequestBody Rol rol){
	        Rol encontrado = service.buscar(rol.getIdRol());
	        if(encontrado == null) {
	            service.guardar(rol);
	            return ResponseEntity.ok("El Rol " + rol.getPrivilegio() + " se guardó exitosamente");
	        } else {
	            return ResponseEntity.status(HttpStatus.FOUND).body("Este registro ya existe en la base de datos");
	        }
	    }
		
		@GetMapping("buscar/{idRol}")
		public Rol buscar(@PathVariable("idRol") int idRol) {
		    return service.buscar(idRol);
		}
		
		@DeleteMapping("eliminar")
		public void eliminar(@RequestParam int idRol) {
		    service.eliminar(idRol);
		}
		
		// editar
		@PutMapping(value = "editar")
				public void editar(@RequestBody Rol rol) { 
					service.editar(rol);
				}

}
