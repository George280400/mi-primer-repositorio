package com.mx.Categoria.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Categoria.DTOs.CategoriaProductoDTO;
import com.mx.Categoria.DTOs.ProductoDTO;
import com.mx.Categoria.Entity.Categoria;
import com.mx.Categoria.Repository.ICategoriaRepository;
@Service

public class CategoriaService implements ICategoriaService {
	
	@Autowired
	 private ICategoriaRepository dao;

	@Override
	public void guardar(Categoria categoria) {
		dao.save(categoria);
		
	}

	@Override
	public void editar(Categoria categoria) {
		dao.save(categoria);
		
	}

	@Override
	public void eliminar(int idCategoria) {
		
		 dao.deleteById(idCategoria);
		
	}

	@Override
	public Categoria buscar(int idCategoria) {
		
		return dao.findById(idCategoria).orElse(null);
	}

	@Override
	public List<Categoria> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}
	
	//inyectar el bean RestTemplate para poder hacer las peticiones HTTP a otros servicios
	@Autowired
	private RestTemplate restTemplate;
	
	//declaracion del metodo filtrar los productos por categoria
	public CategoriaProductoDTO obtenerCategoriaConProductos(int categoriaId) {
		//buscar si la categoria existe
		Categoria categoria = dao.findById(categoriaId).orElse(null);
		if(categoria == null) {
			return null;
		}
		
		//consumir el microservicio de productos
		ProductoDTO[] productosArray = restTemplate.getForObject(
				"http://localhost:8010/P/buscarPorCategoria/" + categoriaId, 
				ProductoDTO[].class ); // como GetForObject no soporta las listas se coloca en un Array .class
		
		List<ProductoDTO> productos = Arrays.asList(productosArray);
		
		//convertir el array de ProductoDTO en una lista List<ProductoDTO> para trabajar mas comodos
		return new CategoriaProductoDTO(categoria, productos);
	}

}
