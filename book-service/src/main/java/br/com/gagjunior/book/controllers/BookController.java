package br.com.gagjunior.book.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gagjunior.book.models.Book;
import br.com.gagjunior.book.services.BookService;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;
    
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
    	Book book = bookService.findBook(id);
    	if (book == null) {
    		throw new RuntimeException("Book not Found");			
		}
        String port = environment.getProperty("local.server.port");
        book.setEnvironment(port);

        return book;
    }
}
