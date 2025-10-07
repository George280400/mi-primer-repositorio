package com.mx.Carros.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Carros.Dominio.Carros;
import com.mx.Carros.Service.CarrosServiceImp;

@RestController // Indica que la clase es un controlador REST, maneja peticiones HTTP y devuelve
				// datos (JSON/XML).

@RequestMapping(path = "api/Carros") // Define la ruta base o URL que usará el controlador o sus métodos.

@CrossOrigin // es para darle permiso a los clientes que consuman mi ruta sin bloqueo por
				// CORS

public class Carrosws {

	@Autowired // inyeccion del servicio
	private CarrosServiceImp service;

	//listar
	@GetMapping(value = "listar") // es una peticion GET
	public List<Carros> listar() {
		return service.listar();
	}

	// guardar
	@PostMapping(value = "guardar") // es para una peticion POST
	public void guardar(@RequestBody Carros carro) // @requestBody es para especificar que en mi solicitud HTTP que debo incluir un cuerpo sin el id
	{
		service.guardar(carro);
	}

	// buscar 
	@PostMapping(value = "buscar") // es para una peticion POST
	public Carros buscar(@RequestBody Carros carro) { // @requestBody se le pasa el id a buscar en el body
		return service.buscar(carro);
	}

	@DeleteMapping(value = "eliminar") // es para una peticion DELETE
	public void eliminar(@RequestBody Carros carro) { // en el body se le pasa el id a eliminar
		service.eliminar(carro);
	}

	// editar
	@PutMapping(value = "editar")
	public void editar(@RequestBody Carros carro) { //se le pasa el id y los campos a editar en el body
		service.editar(carro);
	}

}
