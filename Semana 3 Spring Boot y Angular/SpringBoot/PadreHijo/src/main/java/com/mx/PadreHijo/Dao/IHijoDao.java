package com.mx.PadreHijo.Dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.PadreHijo.Dominio.Hijo;
@Repository
public interface IHijoDao extends JpaRepository<Hijo, Integer>{

	//jpaRepository nos ofrece mas operaciones que crud y tambien poder hacer consultas directamente en la bd
	
@Query(value = "SELECT * FROM HIJO H WHERE UPPER(H.HOBBIE) = UPPER(:hobbie)",nativeQuery = true)
public List<Hijo> findByHobbie(String hobbie);
}
