package com.mx.Prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Prueba.Entity.Transaccion;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long>{

}
