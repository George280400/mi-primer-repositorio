package com.mx.Receptor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mx.Receptor.Entity.Contrato;

@Service
public interface ContratoRepository extends JpaRepository<Contrato, String>{
	
	boolean existsByIdContrato(String idContrato);

}
