package com.mx.Computadora.Controller;

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

import com.mx.Computadora.Dominio.Computadora;
import com.mx.Computadora.Service.ComputadoraServiceImp;

@RestController //es la anotacion que se utiliza para crear controladores RESTFul. un controlador RESTFul es un componente que maneja
//la solicitudes HTTP Y proporciona una respuesta HTTP adecuada

@RequestMapping(path = "api/Compu") // es la anotacion en spring que se utiliza para asignar uRL a un metodo de controlador o una clase
//completa de controladores la conocere como mi ruta base

@CrossOrigin //es para darle permiso a los clientes que consuman mi ruta
public class Computadoraws {
	
	//inyeccion del servicio
	@Autowired
	private ComputadoraServiceImp service;
	// URL = protocolo: host:puerto/path
	
	//http://localhost:8080/api/Compu
	
	//listar -> //http://localhost:8080/api/Compu/listar
	
@GetMapping(value = "listar") // es una notacion que se utiliza para mapear una solicitud http GET a un metodo en especifico en un 
//controlador: es una combinacion de @request mapping y @getmapping lo que significa que solo se aceptaran solicitudes http get
//en el metodo anotado, y si utilizamos (values = "listar") estoy agregando un recurso extra a mi ruta

public List<Computadora> listar(){
	return service.listar();
}

//guardar --> http://localhost:8080/api/Compu
@PostMapping(value = "guardar")
public void guardar(@RequestBody Computadora computadora) //@requestBody es para especificar que en mi solicitud HTTP debo incluir un cuerpo
{
service.guardar(computadora);
}

//buscar ->  http://localhost:8080/api/Compu
@PostMapping(value = "buscar")
public Computadora buscar(@RequestBody Computadora computadora) {
	return service.buscar(computadora);
}


@DeleteMapping(value = "eliminar")
public void eliminar(@RequestBody Computadora computadora) {
	service.eliminar(computadora);
}

//editar -< http://localhost:8080/api/Compu
@PutMapping(value = "editar")
public void editar(@RequestBody Computadora computadora) {
	service.editar(computadora);
}







}
