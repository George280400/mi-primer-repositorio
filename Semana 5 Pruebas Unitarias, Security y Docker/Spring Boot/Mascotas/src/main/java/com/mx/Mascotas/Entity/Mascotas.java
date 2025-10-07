package com.mx.Mascotas.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Entity
@Table
@Data
public class Mascotas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMascota;
	@NotBlank(message = "El Nombre no puede estar vacio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El Nombre solo puede contener letras y espacios")
	private String nombre;
	@NotBlank(message = "La Raza  no puede estar vacia")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El Raza solo puede contener letras y espacios")
	private String raza;
	@Min(value = 0, message = "Introduzca una edad valida")
    @Max(value = 99, message = "Introduzca una edad valida")
	private int edad;
	@NotBlank(message = "La Razon de la no puede estar  vacia")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "La razon de la cita solo puede contener letras y espacios")
	private String razonCita;
	@NotNull(message = "Debe especificar un cliente")
	@Min(value = 1, message = "Debe seleccionar un cliente válido")
	private int clienteId;
	@NotNull(message = "Debe especificar un responsable")
	@Min(value = 1, message = "Debe seleccionar un responsable válido")
	private int responsableId;


}
