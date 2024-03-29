package br.com.gagjunior.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gagjunior.book.models.Book;
import br.com.gagjunior.book.proxy.CambioProxy;
import br.com.gagjunior.book.response.Cambio;
import br.com.gagjunior.book.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

	@Autowired
	private Environment environment;

	@Autowired
	private BookService bookService;

	@Autowired
	private CambioProxy cambioProxy;

	@Operation(summary = "Find book by ID")
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

		Book book = bookService.findBook(id);
		if (book == null) {
			throw new RuntimeException("Book not Found");
		}

		Cambio cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);

		String port = environment.getProperty("local.server.port");
		book.setEnvironment("Book port: " + port + " Cambio port: " + cambio.getEnvironment());
		book.setPrice(cambio.getConvertedValue());

		return book;
	}
}
