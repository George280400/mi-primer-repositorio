package com.mx.Veterinarias.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Veterinarias.Entity.Veterinaria;
import com.mx.Veterinarias.Repository.IVeterinariaRepository;


@Service
public class VeterinariaServiceImp implements IVeterinariaService{
	
	@Autowired
	private IVeterinariaRepository dao;

	@Override
	public void guardar(Veterinaria veterinaria) {
		
		dao.save(veterinaria);
	}

	@Override
	public void editar(Veterinaria veterinaria) {
		
		dao.save(veterinaria);
	}

	@Override
	public void eliminar(int idVeterinaria) {
		
		dao.deleteById(idVeterinaria);
	}

	@Override
	public Veterinaria buscar(int idVeterinaria) {
		
		return dao.findById(idVeterinaria).orElse(null);
	}

	@Override
	public List<Veterinaria> listar() {
		return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}

}
