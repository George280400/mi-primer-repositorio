package com.mx.Cajero.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Cajero.Entity.Cajero;
import com.mx.Cajero.Repository.ICajeroRepository;

import jakarta.transaction.Transactional;

@Service
public class CajeroServiceImp {
	
	@Autowired
	private ICajeroRepository repository;
	
	@Transactional //gestiona las transacciones de base de datos.
	public Map<Double, Integer> retirar(Double monto) {
		
		//se obtiene la lista de las denominaciones de mayor a menor
        List<Cajero> denominaciones = repository.findAllByOrderByDenominacionDesc();
        
        //resultado del retiro denominacion y cantidad
        Map<Double, Integer> resultado = new LinkedHashMap<>();
        
        //dinero que falta entregar
        double restante = monto;
        
        //recorre cada denominacion
        for (Cajero cajero : denominaciones) {
        	//cuantas piezas se pueden usar por denominacion
            int usar = (int) Math.min(restante / cajero.getDenominacion(), cajero.getCantidad());
            if (usar > 0) {
            	
            	//se guarda el resultado cuántas piezas de esta denominación entregamos.
                resultado.put(cajero.getDenominacion(), usar);
                
                //se descuenta del restante el valor de las piezas usadas.
                restante -= usar * cajero.getDenominacion();
                
                //actualiza los datos de la base de datos
                cajero.setCantidad(cajero.getCantidad() - usar);
                repository.save(cajero);
            }
        }
        
        //si la operacion no se completa lanza error y hace el rollback

        if (restante > 0) {
            throw new RuntimeException("No hay suficiente cambio para completar el retiro.");
        }
        //devuelve el desglose del retiro
        return resultado;
    }

}
