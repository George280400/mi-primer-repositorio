package com.mx.Mascotas.Service;

import java.util.List;

import com.mx.Mascotas.Entity.Mascotas;



public interface IMascotasService {
	
	public void guardar(Mascotas mascotas);
	public void editar(Mascotas mascotas);
	public void eliminar(int idMascota);
	public Mascotas buscar(int idMascota);
	public List<Mascotas> listar();

}
