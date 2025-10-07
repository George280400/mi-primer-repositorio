package com.mx.Ventas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Ventas.Entity.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer>{

}
