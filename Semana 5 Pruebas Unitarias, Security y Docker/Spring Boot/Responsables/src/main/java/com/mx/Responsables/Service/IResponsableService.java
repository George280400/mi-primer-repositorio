package com.mx.Responsables.Service;

import java.util.List;

import com.mx.Responsables.Entity.Responsables;

public interface IResponsableService {
	
	public void guardar(Responsables responsable);
	public void editar(Responsables responsable);
	public void eliminar(int idResponsable);
	public Responsables buscar(int idResponsable);
	public List<Responsables> listar();

}
