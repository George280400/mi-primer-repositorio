package com.mx.Prueba.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Prueba.DTO.TransaccionRequest;
import com.mx.Prueba.Entity.Transaccion;
import com.mx.Prueba.Repository.ITransaccionRepository;

@RestController
@RequestMapping("/api2")
public class Api2Controller {
	
	 private final ITransaccionRepository repo;

	    public Api2Controller(ITransaccionRepository repo) {
	        this.repo = repo;
	    }
	    
	    @PostMapping("/guardar")
	    public Map<String, Object> guardar(@RequestBody TransaccionRequest request) {
	        Transaccion t = new Transaccion();
	        t.setOperacion(request.getOperacion());
	        t.setImporte(request.getImporte());
	        t.setCliente(request.getCliente());
	        t.setReferencia(String.valueOf(new Random().nextInt(900000) + 100000));
	        t.setEstatus("Aprobada");

	        repo.save(t);

	        Map<String, Object> resp = new HashMap<>();
	        resp.put("id", t.getId());
	        resp.put("estatus", t.getEstatus());
	        resp.put("referencia", t.getReferencia());
	        resp.put("operacion", t.getOperacion());
	        return resp;
	    }
	    
	    @PatchMapping("/cancelar")
	    public ResponseEntity<?> cancelar(@RequestBody Map<String, String> body) {
	        Long id = Long.valueOf(body.get("id"));
	        return repo.findById(id).map(t -> {
	            t.setEstatus("Cancelada");
	            repo.save(t);
	            return ResponseEntity.ok(t);
	        }).orElse(ResponseEntity.notFound().build());
	    }
	    
	    @GetMapping("/listar")
	    public List<Transaccion> listar() {
	        return repo.findAll();
	    }

}
