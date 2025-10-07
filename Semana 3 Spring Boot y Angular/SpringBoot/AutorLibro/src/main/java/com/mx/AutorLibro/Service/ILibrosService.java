package com.mx.AutorLibro.Service;
import java.util.List;

import com.mx.AutorLibro.Dominio.Libros;


public interface ILibrosService {
	
	public Libros guardar(Libros libro, int idAutor); //crear libro para autor
	List<Libros> obtenerLibrosPorAutor(int autorId); //obtener libros por autor

}
