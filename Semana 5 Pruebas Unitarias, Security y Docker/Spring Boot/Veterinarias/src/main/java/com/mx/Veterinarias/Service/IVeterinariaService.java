package com.mx.Veterinarias.Service;

import java.util.List;

import com.mx.Veterinarias.Entity.Veterinaria;


public interface IVeterinariaService {
	
	public void guardar(Veterinaria veterinaria);
	public void editar(Veterinaria veterinaria);
	public void eliminar(int idVeterinaria);
	public Veterinaria buscar(int idVeterinaria);
	public List<Veterinaria> listar();

}
