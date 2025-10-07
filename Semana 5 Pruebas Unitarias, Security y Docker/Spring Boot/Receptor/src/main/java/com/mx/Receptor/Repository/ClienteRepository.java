package com.mx.Receptor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Receptor.Entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	boolean existsByCurp(String curp);

}
