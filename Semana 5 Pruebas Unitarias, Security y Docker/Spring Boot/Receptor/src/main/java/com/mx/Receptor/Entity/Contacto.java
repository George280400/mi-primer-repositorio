package com.mx.Receptor.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "CONTACTO")
@Data
public class Contacto {
	
	@Id
    @Column(name = "IDCONTACTO")
    private String idContacto;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne
    @JoinColumn(name = "IDCLIENTEDIGITAL")
    private Cliente cliente;

}
