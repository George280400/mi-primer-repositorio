package com.mx.PadreHijo.Controller;

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

import com.mx.PadreHijo.Dominio.Padre;
import com.mx.PadreHijo.Service.PadreServiceImp;

@RestController
@RequestMapping("/api/padre")
@CrossOrigin
public class Padrews {
	
	@Autowired
	private PadreServiceImp service;
	
	@GetMapping("listar")
	public List<Padre> listar()
	{
		return service.listar();
	}
	
	// guardar
	@PostMapping("guardar")
    public ResponseEntity<String> guardar(@RequestBody Padre padre){
        Padre encontrado = service.buscar(padre.getIdPadre());
        if(encontrado == null) {
            service.guardar(padre);
            return ResponseEntity.ok("El padre " + padre.getNombre() + " se guardó exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body("Este registro ya existe en la base de datos");
        }
    }
 
		
		@GetMapping("buscar/{idPadre}")
		public Padre buscar(@PathVariable("idPadre") int idPadre) {
		    return service.buscar(idPadre);
		}
		
		@DeleteMapping("eliminar")
		public void eliminar(@RequestParam int idPadre) {
		    service.eliminar(idPadre);
		}
		
		
		// editar
		@PutMapping(value = "editar")
		public void editar(@RequestBody Padre padre) { //se le pasa el id y los campos a editar en el body
			service.editar(padre);
		}



}
