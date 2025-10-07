package com.mx.Receptor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mx.Receptor.Entity.Domicilio;

@Service
public interface DomicilioRepository extends JpaRepository<Domicilio, String> {

}
