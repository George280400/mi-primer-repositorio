package com.mx.Receptor.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;
@Entity
@Table(name = "DOCUMENTACION")
@Data
public class Documentacion {
	
	 @Id
	    @Column(name = "IDDOCUMENTACION")
	    private String idDocumentacion;

	    @Column(name = "TIPOIDENTIFICACION")
	    private String tipoIdentificacion;

	    @Column(name = "NUMEROIDENTIFICACION")
	    private String numeroIdentificacion;

	    @OneToOne
	    @JoinColumn(name = "IDCLIENTEDIGITAL")
	    private Cliente cliente;

}
