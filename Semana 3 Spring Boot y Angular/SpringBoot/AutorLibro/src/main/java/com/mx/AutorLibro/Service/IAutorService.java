package com.mx.AutorLibro.Service;
import java.util.List;

import com.mx.AutorLibro.Dominio.Autor;


public interface IAutorService {
	
	public Autor guardar(Autor autor); //guardar autor

	public Autor buscar(int idAutor); //buscar autor por id

}
