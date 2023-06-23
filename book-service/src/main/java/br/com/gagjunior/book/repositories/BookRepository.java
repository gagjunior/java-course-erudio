package br.com.gagjunior.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gagjunior.book.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
