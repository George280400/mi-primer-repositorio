package com.mx.Cajero.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.mx.Cajero.Entity.Cajero;
import com.mx.Cajero.Repository.ICajeroRepository;
import com.mx.Cajero.Service.CajeroServiceImp;

@RestController
@RequestMapping("/api/cajero")
@CrossOrigin
public class CajeroWS {
	
	@Autowired
    private CajeroServiceImp service;
	
	@Autowired
	private ICajeroRepository repository;
	
	@PostMapping("/retirar/{monto}")
    public ResponseEntity<?> retirar(@PathVariable Double monto) {
        try {
            return ResponseEntity.ok(service.retirar(monto));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	@GetMapping("/estado") //ver la cantidad de billetes disponibles por denominacion
	public List<Cajero> getEstado() {
	    return repository.findAllByOrderByDenominacionDesc();
	}


}
