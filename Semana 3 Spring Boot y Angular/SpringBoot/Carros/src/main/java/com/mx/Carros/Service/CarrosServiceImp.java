package com.mx.Carros.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Carros.Dao.ICarrosDao;
import com.mx.Carros.Dominio.Carros;

@Service //Le dice a Spring que la clase es un servicio (lógica de negocio) y debe gestionarla como un bean.

public class CarrosServiceImp implements ICarrosService{
	
	@Autowired //Le dice a Spring que inyecte automáticamente la dependencia adecuada (sin usar new).
	
	private ICarrosDao dao;

	@Override
	public void guardar(Carros carro) {
		
		dao.save(carro);
		
	}

	@Override
	public void editar(Carros carro) {
		
		dao.save(carro); // no existe un metodo en especifico que edite pero al guardar informacion con un mismo id remplaza la informacion anterior
		
	}

	@Override
	public void eliminar(Carros carro) {
		
		dao.delete(carro);
		
	}

	@Override
	public Carros buscar(Carros carro) {
		
		return dao.findById(carro.getIdCarro()).orElse(null);
	}

	@Override
	public List<Carros> listar() {
		
		return (List<Carros>) dao.findAll();
	}

}
