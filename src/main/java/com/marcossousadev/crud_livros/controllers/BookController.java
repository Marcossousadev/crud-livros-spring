package com.marcossousadev.crud_livros.controllers;

import com.marcossousadev.crud_livros.business.BookService;
import com.marcossousadev.crud_livros.infrastructure.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/criar")
    public ResponseEntity<Void> createBook(@RequestBody Book body){
        bookService.createBook(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    // pathParam é muito usado para busca de recursos
    // já queryParam é muito usado para fazer filtros
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Integer id) {
        bookService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable Integer id, @RequestBody Book body) {
        bookService.updateBookById(id, body);
        return ResponseEntity.ok("Livro atualizado com sucesso!");
    }
}
