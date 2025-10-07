package com.mx.Proveedor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Proveedor.Entity.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer>{

}
