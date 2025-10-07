package com.mx.Producto.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Producto.Entity.Producto;
import com.mx.Producto.Repository.IProductoRepository;

@Service
public class ProductoServiceImp implements IProductoService{
	//patron de diseño del tipo de inversion de control
	@Autowired
	private IProductoRepository dao;

	@Override
	public void guardar(Producto producto) {
		
		dao.save(producto);
	}

	@Override
	public void editar(Producto producto) {
		
		dao.save(producto);
	}

	@Override
	public void eliminar(Long codigoBarras) {
		
		dao.deleteById(codigoBarras);
	}

	@Override
	public Producto buscar(Long codigoBarras) {
		
		return dao.findById(codigoBarras).orElse(null);
	}

	@Override
	public List<Producto> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}
	
	//metodo personaluizados
	//buscarPorCategoria
	public List<Producto> buscarPorCategoria(int categoriaId){
	return dao.findByCategoriaId(categoriaId);
	}
	
	//buscar porProveedor
	public List<Producto> buscarPorProveedor(int proveedorId) {
	return dao. findByProveedorId(proveedorId);
	}

}
