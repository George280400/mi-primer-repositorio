package com.mx.Ventas.Service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Ventas.DTOs.ClienteDTO;
import com.mx.Ventas.DTOs.ProductoDTO;
import com.mx.Ventas.DTOs.VentaClienteDTO;
import com.mx.Ventas.DTOs.VentaProductoDTO;
import com.mx.Ventas.Entity.Venta;
import com.mx.Ventas.FeignClient.ClienteFeignClient;
import com.mx.Ventas.FeignClient.ProductoFeignClient;
import com.mx.Ventas.Repository.IVentaRepository;

@Service
public class VentaServiceImp implements IVentaService{

	@Autowired
	private IVentaRepository dao;
	@Override
	public void guardar(Venta venta) {
		dao.save(venta);
		
	}

	@Override
	public void editar(Venta venta) {
		dao.save(venta);
		
	}

	@Override
	public void eliminar(int idVenta) {
		dao.deleteById(idVenta);
		
	}

	@Override
	public Venta buscar(int idVenta) {
		return dao.findById(idVenta).orElse(null);
	}

	@Override
	public List<Venta> listar() {
		return dao.findAll(Sort.by(Sort.Direction.ASC, "fecha"));
	}
	
	@Autowired
	private ProductoFeignClient productoFC;
	
	public VentaProductoDTO obtenerVentasProd(int idVenta) {
		
		//validar si existe la venta
		Venta venta = dao.findById(idVenta)
				.orElseThrow(() -> new RuntimeException("Venta no existe"));
		
		//buscar el producto en el microservicio de Producto (Consumir)
		
		ProductoDTO producto = productoFC.buscar(venta.getCodigoBarras());
		
		//construir una respuesta
		VentaProductoDTO dto = new VentaProductoDTO();
		dto.setIdVenta(venta.getIdVenta());
		dto.setFecha(venta.getFecha());
		dto.setClienteId(venta.getClienteId());
		dto.setMetodoPago(venta.getMetodoPago());
		dto.setEmpleadoId(venta.getEmpleadoId());
		dto.setProducto(producto);
		return dto;
		
	}
	
	@Autowired
	private ClienteFeignClient clienteFC;
	
	public VentaClienteDTO obtenerVentasClien(int idVenta) {
		
		//validar si existe la venta
		Venta venta = dao.findById(idVenta)
				.orElseThrow(() -> new RuntimeException("Venta no existe"));
		
		//buscar el producto en el microservicio de Producto (Consumir)
		
		ClienteDTO cliente = clienteFC.buscar(venta.getClienteId());
		
		//construir una respuesta
		VentaClienteDTO dto = new VentaClienteDTO();
		dto.setIdVenta(venta.getIdVenta());
		dto.setFecha(venta.getFecha());
		dto.setClienteId(venta.getClienteId());
		dto.setMetodoPago(venta.getMetodoPago());
		dto.setEmpleadoId(venta.getEmpleadoId());
		dto.setCliente(cliente);
		return dto;
		
	}

}
