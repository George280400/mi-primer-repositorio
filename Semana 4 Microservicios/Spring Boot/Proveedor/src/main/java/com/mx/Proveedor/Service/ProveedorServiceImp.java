package com.mx.Proveedor.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Proveedor.DTOs.ProductoDTO;
import com.mx.Proveedor.DTOs.ProveedorProductoDTO;
import com.mx.Proveedor.Entity.Proveedor;
import com.mx.Proveedor.Repository.IProveedorRepository;

@Service
public class ProveedorServiceImp implements IProveedorService{
	
	@Autowired
	 private IProveedorRepository dao;

	@Override
	public void guardar(Proveedor proveedor) {
		
		dao.save(proveedor);
	}

	@Override
	public void editar(Proveedor proveedor) {
		
		dao.save(proveedor);
	}

	@Override
	public void eliminar(int idProveedor) {
		
		dao.deleteById(idProveedor);
	}

	@Override
	public Proveedor buscar(int idProveedor) {
		
		return dao.findById(idProveedor).orElse(null);
	}

	@Override
	public List<Proveedor> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}
	
	//inyectar el bean RestTemplate para poder hacer las peticiones HTTP a otros servicios
		@Autowired
		private RestTemplate restTemplate;
		
		//declaracion del metodo filtrar los productos por proveedor
		
		public ProveedorProductoDTO obtenerProveedorConProductos(int proveedorId) {
			
			//buscar si el proveedor existe
			Proveedor proveedor = dao.findById(proveedorId).orElse(null);
			
			// si no existe regresa null
			if(proveedor == null) {
				return null;
			}
			
			//consumir el microservicio de productos
			ProductoDTO[] productosArray = restTemplate.getForObject(
					"http://localhost:8010/P/buscarPorProveedor/" + proveedorId, //restTemplate.getForObject hace una petición GET a la URL
					
					ProductoDTO[].class ); // como GetForObject no soporta las listas se coloca en un Array .class
			
			
			//Convertir el array de productos en una lista para trabajar más cómodamente
			List<ProductoDTO> productos = Arrays.asList(productosArray);
			
			
			return new ProveedorProductoDTO(proveedor, productos); //retornar el objeto DTO con el provedor y la lista de productos
		}

}
