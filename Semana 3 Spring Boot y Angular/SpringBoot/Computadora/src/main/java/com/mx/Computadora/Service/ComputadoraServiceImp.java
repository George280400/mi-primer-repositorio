package com.mx.Computadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Computadora.Dao.IComputadoraDao;
import com.mx.Computadora.Dominio.Computadora;
@Service //indica que esta clase sera gestionada por el contenedor de beans de spring y debera sera ser inyectado en otra clase
//indica que esta clase provee un conjunto de funcionalidades que pueden ser utilizadas en otra clase
public class ComputadoraServiceImp implements IComputadoraService{
@Autowired //indica la inyeccion de una dependencia para permitir que la aplicacion sea escalable(vamos a inyectar el dao para poder usar el crud repository)
	
//la inyeccion de independencias es un patron de diseño del tipo de inversion de control(IoC)
//en lugar de que una clase cree sus objetos de una forma indirecta Spring se encarga de inyectarlos automaticamente

private IComputadoraDao dao;

@Override
	public void guardar(Computadora computadora) {
		dao.save(computadora);
		
	}

	@Override
	public void editar(Computadora computadora) {
		dao.save(computadora);
		//no existe un metodo en especifico que edite o remplaze la informacion, pero al guardar informacion con un mismo id remplaza la informacion anterior
	}

	@Override
	public void eliminar(Computadora computadora) {
		dao.delete(computadora);
		
	}

	@Override
	public Computadora buscar(Computadora computadora) {
		
		return dao.findById(computadora.getIdCompu()).orElse(null);
	}

	@Override
	public List<Computadora> listar() {
		
		return (List<Computadora>) dao.findAll();
	}

}
