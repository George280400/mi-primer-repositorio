package com.mx.Receptor.Entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "PRODUCTO1")
@Data
public class Producto {
	
	@Id
    @Column(name = "IDPRODUCTO")
    private String idProducto;

    @Column(name = "NOMBREPRODUCTO")
    private String nombreProducto;

}
