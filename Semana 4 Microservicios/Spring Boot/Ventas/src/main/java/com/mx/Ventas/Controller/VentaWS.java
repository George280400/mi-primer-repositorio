package com.mx.Ventas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Ventas.DTOs.VentaClienteDTO;
import com.mx.Ventas.DTOs.VentaProductoDTO;
import com.mx.Ventas.Entity.Venta;
import com.mx.Ventas.Service.VentaServiceImp;

@RestController
@RequestMapping(path = "/V")
public class VentaWS {
	
	@Autowired
	private VentaServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Venta> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay registros en la base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Venta venta) {
			service.guardar(venta);
			return ResponseEntity.ok("El registro: " + venta.getIdVenta() + " se registro con exito");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Venta venta) {
			service.editar(venta);
			return ResponseEntity.ok("Edicion exitosa");
	}
	
	@GetMapping("/{idVenta}")
	public ResponseEntity<?> buscar(@PathVariable int idVenta) {
		Venta encontrado = service.buscar(idVenta);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El registro no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@DeleteMapping("/{idVenta}")
	public ResponseEntity<?> eliminar(@PathVariable int idVenta) {
		Venta encontrado = service.buscar(idVenta);
		if (encontrado != null) {
			service.eliminar(idVenta);
			return ResponseEntity.ok("El registro se elimino con exito");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/productos/{idVenta}")
	public VentaProductoDTO obtenerListaProd(@PathVariable int idVenta) {
	return service.obtenerVentasProd(idVenta);

	}
	
	@GetMapping("/clientes/{idVenta}")
	public VentaClienteDTO obtenerListaClient(@PathVariable int idVenta) {
	return service.obtenerVentasClien(idVenta);

	}

}
