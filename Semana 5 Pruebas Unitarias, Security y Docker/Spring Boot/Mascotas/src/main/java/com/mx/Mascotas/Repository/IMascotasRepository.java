package com.mx.Mascotas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Mascotas.Entity.Mascotas;
@Repository
public interface IMascotasRepository extends JpaRepository<Mascotas, Integer>{

}
