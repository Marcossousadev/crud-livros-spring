package com.marcossousadev.crud_livros.infrastructure.repository;

import com.marcossousadev.crud_livros.infrastructure.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
