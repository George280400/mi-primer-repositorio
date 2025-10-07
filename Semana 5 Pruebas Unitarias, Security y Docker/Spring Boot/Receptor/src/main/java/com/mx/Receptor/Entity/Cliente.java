package com.mx.Receptor.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "CLIENTE")
@Data
public class Cliente {
	
	    @Id
	    @Column(name = "IDCLIENTEDIGITAL")
	    private String idClienteDigital;

	    @Column(name = "NOMBRE")
	    private String nombre;

	    @Column(name = "APELLIDOPATERNO")
	    private String apellidoPaterno;

	    @Column(name = "APELLIDOMATERNO")
	    private String apellidoMaterno;

	    @Column(name = "GENERO")
	    private String genero;

	    @Column(name = "FECHANACIMIENTO")
	    @Temporal(TemporalType.DATE) //Se almacena solo la fecha
	    private Date fechaNacimiento;

	    @Column(name = "CURP")
	    private String curp;
	    
	 // Relaciones 1 a 1 con otras entidades
	    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	    private Contacto contacto;

	    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	    private Domicilio domicilio;

	    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	    private Documentacion documentacion;
	    
	    // Relaciones 1 a muchos
	    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	    private List<Beneficiario> beneficiarios;

	    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	    private List<Contrato> contratos;

}
