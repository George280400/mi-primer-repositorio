package com.mx.Ventas.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "VENTA1")
@Data
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	private LocalDate fecha;
	private int clienteId;
	private int total;
	private String metodoPago;
	private int empleadoId;
	private Long codigoBarras;
	
	
   @PrePersist
   public void prePersist() {
	   this.fecha = LocalDate.now();
   }
}
