package com.mx.Tareas.Dominio;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table
@Data //Genera automaticamente getters, setters, toString, equals y hashCode
public class Tarea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "El título no puede estar vacío")
	private String titulo;
	 @NotBlank(message = "La descripción no puede estar vacía")
	 private String descripcion;
	 @NotNull(message = "La fecha de creación es obligatoria")
	 @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCreacion;
	 @NotNull(message = "La fecha de vencimiento es obligatoria")
	 @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaVencimiento;
	private String estado;
	
	@AssertTrue(message = "La fecha de vencimiento no puede ser anterior a la fecha de creación")
	public boolean isFechaValida() {
	    if (fechaCreacion == null || fechaVencimiento == null) {
	        return true; // se valida en @NotNull
	    }
	    return !fechaVencimiento.isBefore(fechaCreacion);
	}

}
