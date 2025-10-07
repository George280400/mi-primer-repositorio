package com.mx.Receptor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Receptor.Entity.Producto;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, String>{
}
