package com.mx.Producto.Controller;

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

import com.mx.Producto.Entity.Producto;
import com.mx.Producto.Service.ProductoServiceImp;

@RestController
@RequestMapping(path = "/P")
public class ProductoWS {

	@Autowired
	private ProductoServiceImp service;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<Producto> lista = service.listar();
		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}

	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Producto producto) {
		Producto prod = service.buscar(producto.getCodigoBarras());
		if (prod == null) {
			service.guardar(producto);
			return ResponseEntity.ok("El producto: " + producto.getNombre() + " se registro con exito");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body("{\"MENSAJE\":\"EL REGISTRO YA EXISTE EN LA BASE DE DATOS\"}");
		}
	}

	@GetMapping("/{codigoBarras}")
	public ResponseEntity<?> buscar(@PathVariable Long codigoBarras) {
		Producto encontrado = service.buscar(codigoBarras);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El producto con el codigo de barras: " + codigoBarras + " no esta registrado en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Producto producto) {
		service.editar(producto);
		return ResponseEntity.ok("El producto " + producto.getNombre() + " se edito con exito");
	}

	@DeleteMapping("/{codigoBarras}")
	public ResponseEntity<?> eliminar(@PathVariable Long codigoBarras) {
		Producto eliminado = service.buscar(codigoBarras);
		if (eliminado != null) {
			service.eliminar(codigoBarras);
			return ResponseEntity.ok("El registro se elimino con exito");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este producto no existe en la base de datos");
		}
	}

	// buscar por categoria
	@GetMapping("buscarPorCategoria/{categoriaId}")
	public ResponseEntity<?> buscarPorCategoria(@PathVariable int categoriaId) {
		List<Producto> prod = service.buscarPorCategoria(categoriaId);
		return ResponseEntity.ok(prod);
	}

	@GetMapping("buscarPorProveedor/{proveedorId}")
	public ResponseEntity<?> buscarPorProveedor(@PathVariable int proveedorId) {
		List<Producto> prod = service.buscarPorProveedor(proveedorId);
		return ResponseEntity.ok(prod);
	}

}
