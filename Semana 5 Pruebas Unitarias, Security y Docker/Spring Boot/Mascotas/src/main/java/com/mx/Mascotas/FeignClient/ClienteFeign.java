package com.mx.Mascotas.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Mascotas.DTOs.ClienteDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Clientes", url = "http://localhost:8010/C")
public interface ClienteFeign {
	
	@GetMapping("/{idCliente}")
    ClienteDTO buscar(@PathVariable int idCliente);

}
