package com.mx.Ventas.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Ventas.DTOs.ClienteDTO;
import com.mx.Ventas.DTOs.ProductoDTO;

//sirve para crear un cliente Feign: nombre del microservicio que se consumira y la url que consumira
@FeignClient(name = "Cliente", url = "http://localhost:8014/Client")
public interface ClienteFeignClient {
	
	@GetMapping("/{idCliente}")
	public ClienteDTO buscar(@PathVariable int idCliente);

}
