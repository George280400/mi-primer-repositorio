package com.mx.Libros.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Libros.Modelo.Book;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private List<Book> books;
	
	 
    public BookController() {
        books = new ArrayList<>();
        books.add(new Book(1, "El principito", "Antoine de Saint-Exupéry", 15.5));
        books.add(new Book(2, "Cien años de soledad", "Gabriel García Márquez", 25.0));
    }
    
    //devuelve todos los libros
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // devuelve el libro por el id
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return ResponseEntity.ok(b);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Libro no encontrado\"}");
    }


}
