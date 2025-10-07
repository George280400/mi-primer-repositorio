package com.mx.Receptor.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "BENEFICIARIO")
@Data
public class Beneficiario {
	
	@Id
    @Column(name = "IDBENEFICIARIO")
    private String idBeneficiario;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDOPATERNO")
    private String apellidoPaterno;

    @Column(name = "APELLIDOMATERNO")
    private String apellidoMaterno;

    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "IDCLIENTEDIGITAL")
    private Cliente cliente;

    @OneToOne(mappedBy = "beneficiario", cascade = CascadeType.ALL)
    private DomicilioBeneficiario domicilio;

}
