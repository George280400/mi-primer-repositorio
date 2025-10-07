package com.mx.Carros.Service;

import java.util.List;

import com.mx.Carros.Dominio.Carros;


public interface ICarrosService {
	
	public void guardar(Carros carro);
	public void editar (Carros carro);
	public void eliminar(Carros carro);
	public Carros buscar(Carros carro);
	public List<Carros> listar();

}
