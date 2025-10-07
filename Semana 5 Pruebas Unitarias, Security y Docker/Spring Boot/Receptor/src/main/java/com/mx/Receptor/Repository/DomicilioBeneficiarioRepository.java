package com.mx.Receptor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mx.Receptor.Entity.DomicilioBeneficiario;

@Service
public interface DomicilioBeneficiarioRepository extends JpaRepository<DomicilioBeneficiario, String>{

}
