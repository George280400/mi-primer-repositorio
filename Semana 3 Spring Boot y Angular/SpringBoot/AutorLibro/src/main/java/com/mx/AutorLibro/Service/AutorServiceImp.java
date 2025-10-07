package com.mx.AutorLibro.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.AutorLibro.Dao.IAutorDao;
import com.mx.AutorLibro.Dominio.Autor;


@Service
public class AutorServiceImp implements IAutorService{
	@Autowired
	private IAutorDao dao;

	@Override
	public Autor guardar(Autor autor) {
		
		return dao.save(autor); //se manda a guardar el actor
	}


	@Override
	public Autor buscar(int idAutor) {
		
		 return dao.findById(idAutor) //busca el autor por el id
	                .orElseThrow(() -> new RuntimeException("Autor no encontrado con id: " + idAutor));
	}


}
