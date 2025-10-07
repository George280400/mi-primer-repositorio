package com.mx.Responsables.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Entity
@Table
@Data
public class Responsables {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResponsable;
	@NotBlank(message = "El Nombre no puede estar vacio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El Nombre solo puede contener letras y espacios")
	private String nombre;
	@NotNull(message = "El contacto no puede ser nulo")
	 @Pattern(regexp = "^[0-9]{10}$", message = "El contacto debe contener exactamente 10 dígitos numéricos")
	private String contacto;
	@NotNull(message = "Debe especificar una Veterinaria")
	@Min(value = 1, message = "Debe seleccionar una veterinaria válida")
	private int veterinariaId;

}
