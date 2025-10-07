package com.mx.Prueba.FeignClient;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.mx.Prueba.DTO.TransaccionRequest;

@FeignClient(name = "api2", url = "http://localhost:8080/api2")
public interface Api2Client {
	
	 @PostMapping("/guardar")
	    Map<String, Object> guardar(TransaccionRequest request);

}
