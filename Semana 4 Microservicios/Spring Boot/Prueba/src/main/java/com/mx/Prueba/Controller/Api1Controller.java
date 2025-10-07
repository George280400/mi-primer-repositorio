package com.mx.Prueba.Controller;

import java.nio.charset.StandardCharsets;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.hash.Hashing;

import com.mx.Prueba.DTO.TransaccionRequest;
import com.mx.Prueba.FeignClient.Api2Client;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api1")
@Valid
@CrossOrigin
public class Api1Controller {
	
	private final Api2Client api2Client;

    public Api1Controller(Api2Client api2Client) {
        this.api2Client = api2Client;
    }
    
    @PostMapping("/procesar")
    public ResponseEntity<?> procesar(@Valid @RequestBody TransaccionRequest request) throws Exception {
        String datos = request.getOperacion() + request.getImporte() + request.getCliente();
        String sha512 = Hashing.sha512().hashString(datos, StandardCharsets.UTF_8).toString(); //// Calcula el hash SHA-512 de los datos
        System.out.println("SHA calculado: " + sha512);

        if (!sha512.equals(request.getSha())) {
            return ResponseEntity.badRequest().body("Hash inválido");
        }

        return ResponseEntity.ok(api2Client.guardar(request));
    }

}
