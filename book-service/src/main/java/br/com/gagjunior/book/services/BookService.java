package br.com.gagjunior.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gagjunior.book.models.Book;
import br.com.gagjunior.book.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book findBook(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

}
