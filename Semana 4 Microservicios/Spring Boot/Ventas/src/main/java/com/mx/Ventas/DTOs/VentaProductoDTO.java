package com.mx.Ventas.DTOs;

import java.time.LocalDate;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class VentaProductoDTO {
	
	private int idVenta;
	private LocalDate fecha;
	private int clienteId;
	private int total;
	private String metodoPago;
	private int empleadoId;
	private ProductoDTO producto;

}
