package com.mx.PadreHijo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mx.PadreHijo.Dominio.Hijo;
import com.mx.PadreHijo.Service.HijoServiceImp;

@RestController
@RequestMapping("/api/hijo")
@CrossOrigin

public class Hijows {
	
	@Autowired
	private HijoServiceImp service;
	
	@GetMapping("listar")
	public List<Hijo> listar()
	{
		return service.listar();
	}
	
	// guardar
		@PostMapping(value = "guardar") // es para una peticion POST
		public void guardar(@RequestBody Hijo hijo) // @requestBody es para especificar que en mi solicitud HTTP que debo incluir un cuerpo sin el id
		{
			service.guardar(hijo);
		}
		
		@GetMapping("buscar/{id}")
		public Hijo buscar(@PathVariable("id") int idHijo) {
		    return service.buscar(idHijo);
		}
		
		@DeleteMapping("eliminar")
		public void eliminar(@RequestParam int idHijo) {
		    service.eliminar(idHijo);
		}
		
		// editar
		@PutMapping(value = "editar")
		public void editar(@RequestBody Hijo hijo) { //se le pasa el id y los campos a editar en el body
			service.editar(hijo);
		}

}
