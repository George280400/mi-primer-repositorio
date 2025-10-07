package com.mx.Prueba.DTO;



import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class TransaccionRequest {
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Operación solo letras")
    private String operacion;

    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "Importe debe ser moneda válida")
    private String importe;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Cliente solo letras")
    private String cliente;

    private String sha;

}
