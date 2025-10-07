package com.mx.Mascotas.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Mascotas.DTOs.ResponsableDTO;

@FeignClient(name = "Responsables", url = "http://localhost:8013/R")
public interface ResponsableFeign {
	
	 @GetMapping("/{idResponsable}")
	    ResponsableDTO buscar(@PathVariable int idResponsable);

}
