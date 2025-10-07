package com.mx.Receptor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mx.Receptor.Entity.Contacto;

@Service
public interface ContactoRepository extends JpaRepository<Contacto, String>{
	
	boolean existsByTelefono(String telefono);
	boolean existsByEmail(String email);

}
