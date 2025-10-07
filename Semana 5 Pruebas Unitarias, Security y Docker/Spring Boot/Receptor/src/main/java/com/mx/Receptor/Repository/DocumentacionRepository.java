package com.mx.Receptor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mx.Receptor.Entity.Documentacion;

@Service
public interface DocumentacionRepository extends JpaRepository<Documentacion, String>{
	
	boolean existsByNumeroIdentificacion(String numeroIdentificacion);

}
