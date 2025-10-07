package com.mx.Receptor.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Entity
@Table(name = "CONTRATO")
@Data
public class Contrato {
	
	 @Id
	    @Column(name = "IDCONTRATO")
	    private String idContrato;

	    @Column(name = "FECHAEXPIRACION")
	    @Temporal(TemporalType.DATE)
	    private Date fechaExpiracion;

	    @ManyToOne
	    @JoinColumn(name = "IDCLIENTEDIGITAL")
	    private Cliente cliente;

	    @ManyToOne
	    @JoinColumn(name = "IDPRODUCTO")
	    private Producto producto;

}
