package com.marcossousadev.crud_livros.business;

import com.marcossousadev.crud_livros.infrastructure.entity.Book;
import com.marcossousadev.crud_livros.infrastructure.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository){
        this.repository = repository;
    }

    public void createBook(Book book){
        repository.saveAndFlush(book);
    }

    public Book getBookById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Esse livro não existe!"));
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void updateBookById(Integer id, Book book){
        Book entityBook = getBookById(id);
        Book newDataBook = Book.builder()
                .title(book.getTitle() != null ? book.getTitle() : entityBook.getTitle())
                .author(book.getAuthor() != null ? book.getAuthor() : entityBook.getAuthor())
                .publicationDate(book.getPublicationDate() != null ? book.getPublicationDate() : entityBook.getPublicationDate())
                .id(entityBook.getId())
                .build();
        repository.save(newDataBook);
    }

}
