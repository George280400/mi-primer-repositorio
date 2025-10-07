package com.mx.Receptor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mx.Receptor.Entity.Beneficiario;

@Service
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, String>{

}
