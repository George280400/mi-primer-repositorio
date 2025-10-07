package com.mx.AutorLibro.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.AutorLibro.Dao.IAutorDao;
import com.mx.AutorLibro.Dao.ILibrosDao;
import com.mx.AutorLibro.Dominio.Autor;
import com.mx.AutorLibro.Dominio.Libros;




@Service
public class LibrosServiceImp implements ILibrosService{
	
    @Autowired
    private ILibrosDao libroDao;

    @Autowired
    private IAutorDao autorDao;
    
   

	@Override
	public Libros guardar(Libros libro, int idAutor) {
		//buscar el autor por el ID
	    Autor autor = autorDao.findById(idAutor)
	            .orElseThrow(() -> new RuntimeException("Autor no encontrado con id: " + idAutor));
        
	    //se le asigna al objeto libro el id de autor de la bd
	    libro.setAutorId(autor);

	    // se guarda el libro
	    return libroDao.save(libro);
	}

	

	@Override
	public List<Libros> obtenerLibrosPorAutor(int autorId) {
	    // validar si existe el autor
	    Autor autor = autorDao.findById(autorId)
	            .orElseThrow(() -> new RuntimeException("Autor no encontrado con id: " + autorId));

	    // se obtienen los libros del autor
	    List<Libros> libros = libroDao.findByAutorId_IdAutor(autorId);

	    // mandar el error que el autor no tiene libros
	    if (libros.isEmpty()) {
	        throw new RuntimeException("El autor con id " + autorId + " no tiene libros registrados");
	    }

	    return libros;
	}
}
