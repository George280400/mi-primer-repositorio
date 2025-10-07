package com.mx.Categoria.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Categoria.Entity.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	

}
