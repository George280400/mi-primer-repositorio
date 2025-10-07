package com.mx.Ventas.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Ventas.DTOs.ProductoDTO;
// sirve para crear un cliente Feign: nombre del microservicio que se consumira y la url que consumira
@FeignClient(name = "Producto", url = "http://localhost:8010/P")
public interface ProductoFeignClient {
	
	@GetMapping("/{codigoBarras}")
	public ProductoDTO buscar(@PathVariable Long codigoBarras); 

}
