package com.mx.Emisor.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class ClienteDTO {
	
	private String idClienteDigital;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero;
    private String fechaNacimiento; // dd/MM/yyyy
    private String curp;
    private ContactoDTO contacto;
    private DomicilioDTO domicilio;
    private DocumentacionDTO documentacion;
    private BeneficiarioDTO beneficiario;
    private String idProducto;
    private ContratoDTO contrato;


}
