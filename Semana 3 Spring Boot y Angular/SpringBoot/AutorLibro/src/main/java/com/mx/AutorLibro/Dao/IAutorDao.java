package com.mx.AutorLibro.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.AutorLibro.Dominio.Autor;




@Repository
public interface IAutorDao extends JpaRepository<Autor, Integer>{
	
	public Autor findByNombreIgnoreCase(String nombre);

}
