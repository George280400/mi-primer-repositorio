package com.mx.Cliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Cliente.Entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
