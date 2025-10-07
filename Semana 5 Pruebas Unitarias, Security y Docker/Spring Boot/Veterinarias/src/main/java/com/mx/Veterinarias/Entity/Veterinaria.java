package com.mx.Veterinarias.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity	
@Table
@Data
public class Veterinaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVeterinaria;
	@NotBlank(message = "El Nombre no puede estar  vacio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo puede contener letras y espacios")
	private String nombre;
	@NotBlank(message = "La Direccion no puede estar vacia")
	private String direccion;
	@NotNull(message = "El telefono no puede estar vacio")
	 @Pattern(regexp = "^[0-9]{10}$", message = "El telefono debe contener exactamente 10 dígitos numéricos")
	private String telefono;

}
