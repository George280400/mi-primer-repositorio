package com.mx.Receptor.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;
@Entity
@Table(name = "DOMICILIO")
@Data
public class Domicilio {
	
	 @Id
	    @Column(name = "IDDOMICILIO")
	    private String idDomicilio;

	    @Column(name = "ENTIDADFEDERATIVA")
	    private String entidadFederativa;

	    @Column(name = "MUNICIPIO")
	    private String municipio;

	    @Column(name = "COLONIA")
	    private String colonia;

	    @Column(name = "CALLE")
	    private String calle;

	    @Column(name = "NUMEROINTERIOR")
	    private String numeroInterior;

	    @Column(name = "NUMEROEXTERIOR")
	    private String numeroExterior;

	    @Column(name = "CODIGOPOSTAL")
	    private String codigoPostal;

	    @Column(name = "PAIS")
	    private String pais;

	    @OneToOne
	    @JoinColumn(name = "IDCLIENTEDIGITAL")
	    private Cliente cliente;

}
