package com.mx.Tareas.Service;

import java.util.List;


import com.mx.Tareas.Dominio.Tarea;

public interface ITareaService {
	
	public void guardar(Tarea tarea);
	public void editar (Tarea tarea);
	public void eliminar(Tarea tarea);
	public Tarea buscar(int id);
	public List<Tarea> listar();

}
