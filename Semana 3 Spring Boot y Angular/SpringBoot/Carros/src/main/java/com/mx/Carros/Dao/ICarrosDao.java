package com.mx.Carros.Dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.Carros.Dominio.Carros;



public interface ICarrosDao extends CrudRepository<Carros, Integer>{ //se va a heredar CrudRepository para poder realizar las operaciones CRUD y se la pasa la clase y el tipo de si identificador
	
	//vamos a definir un metodo personalizado
	
	public Carros findByMarca(String marca);

}
