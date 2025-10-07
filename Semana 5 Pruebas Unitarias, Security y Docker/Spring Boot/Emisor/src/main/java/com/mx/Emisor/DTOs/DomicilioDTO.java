package com.mx.Emisor.DTOs;



import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DomicilioDTO {
	
	private String entidadFederativa;
    private String municipio;
    private String colonia;
    private String calle;
    private String numeroInterior;
    private String numeroExterior;
    private String codigoPostal;
    private String pais;

}
