package com.mx.Cajero.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
public class Cajero {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDenominacion;
    private String tipo;
    private Double denominacion;
    private Integer cantidad;
    
    public Cajero() {
    	
    }

}
