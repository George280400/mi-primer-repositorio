package com.mx.Tareas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Tareas.Dao.ITareaDao;
import com.mx.Tareas.Dominio.Tarea;

@Service
public class TareaServiceImp implements ITareaService{
	
@Autowired //Le dice a Spring que inyecte automáticamente la dependencia adecuada (sin usar new).
	
	private ITareaDao dao;

	@Override
	public void guardar(Tarea tarea) {
		dao.save(tarea);
		
	}

	@Override
	public void editar(Tarea tarea) {
		dao.save(tarea);
		
	}

	@Override
	public void eliminar(Tarea tarea) {
		dao.delete(tarea);
		
	}

	@Override
	public Tarea buscar(int id) {
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Tarea> listar() {
		return (List<Tarea>) dao.findAll();
	}

}
