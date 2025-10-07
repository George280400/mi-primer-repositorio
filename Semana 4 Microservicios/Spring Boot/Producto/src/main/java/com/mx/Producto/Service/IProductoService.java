package com.mx.Producto.Service;

import java.util.List;

import com.mx.Producto.Entity.Producto;

public interface IProductoService {
	
	public void guardar(Producto producto);
	public void editar(Producto producto);
	public void eliminar(Long codigoBarras);
	public Producto buscar(Long codigoBarras);
	public List<Producto> listar();

}
