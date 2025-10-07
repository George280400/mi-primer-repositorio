package com.mx.AutorLibro.Dao;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.AutorLibro.Dominio.Libros;




@Repository

public interface ILibrosDao extends JpaRepository<Libros, Integer>{
	
	List<Libros> findByAutorId_IdAutor(int autorId);

}
