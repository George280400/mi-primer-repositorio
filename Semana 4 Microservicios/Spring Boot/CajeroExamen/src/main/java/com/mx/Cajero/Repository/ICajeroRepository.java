package com.mx.Cajero.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Cajero.Entity.Cajero;
@Repository

public interface ICajeroRepository extends JpaRepository<Cajero, Integer>{
	
	List<Cajero> findAllByOrderByDenominacionDesc(); //metodo para ontener la lista de mayor a menor denominacion

}
