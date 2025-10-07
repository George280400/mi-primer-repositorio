package com.mx.Producto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Producto.Entity.Producto;
@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
	
	public List<Producto> findByCategoriaId(int categoriaId);
	public List<Producto> findByProveedorId(int proveedorId);

}
