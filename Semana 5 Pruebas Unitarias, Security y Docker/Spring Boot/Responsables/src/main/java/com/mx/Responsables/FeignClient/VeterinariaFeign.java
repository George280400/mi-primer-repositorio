package com.mx.Responsables.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Responsables.DTOs.VeterinariasDTO;


@FeignClient(name = "Veterinarias", url = "http://localhost:8011/V")
public interface VeterinariaFeign {
	
	@GetMapping("/{idVeterinaria}")
    VeterinariasDTO buscar(@PathVariable int idVeterinaria);

}
