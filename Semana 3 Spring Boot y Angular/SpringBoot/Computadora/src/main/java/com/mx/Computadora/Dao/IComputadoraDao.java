package com.mx.Computadora.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Computadora.Dominio.Computadora;

@Repository //indica que esta interfaz sera gestionada por el contenedor de beans de Spring y debera ser inyectado en otra clase
//@Repository me ayuda a que yo pueda utilizar los metodos declarados en la interfaz mas adelante y construir otra clase

public interface IComputadoraDao extends CrudRepository<Computadora, Integer>{
//Crudrepository me ofrece todos los metods crud para poder modificar mi base de datos 
//y es por eso que este paquete se conoce como la capa de acceso a datos
	//metodo personalizado: utilizando siempre lo que me ofrece el repositorio de DataJPA 
	
	public Computadora findByMarca(String marca);
}
