package com.example.bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")

public class BookController {
	
	private BookService bookService;
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/view")
	private Book viewBook(@RequestParam String s1, @RequestParam String s2) {
		System.out.println("Test s1: "+ s1 + " s2: " +s2 );
		Book book = new Book();
		book.setName("Chien");
		book.setAuthor("DVChien");
		book.setPrice(100);
		//bookService.save(book);
		return book;
	}

	@PostMapping("/add")
	private Book insertBook(@RequestBody Book book) {
		return bookService.save(book);
	}
	
	@PutMapping("/update/{id}")
	private ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Long id) {
		Book currentBook = bookService.findById(id);
		if(currentBook == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		currentBook.setName(book.getName());
		currentBook.setAuthor(book.getAuthor());
		currentBook.setPrice(book.getPrice());
		bookService.save(currentBook);
		return new ResponseEntity<>(currentBook, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	private ResponseEntity<Book> removeBook(@RequestBody Long id) {
		Book book = bookService.findById(id);
		if(book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		bookService.removeBook(book);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Book> findById(@PathVariable Long id) {
		try {
			Book book = bookService.findById(id);
			return new ResponseEntity<>(book, HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/obj/{id}")
	private ResponseEntity<Object> findByIdObj(@PathVariable Long id) {
		try {
			Object book = bookService.findByIdObj(id);
			return new ResponseEntity<>(book, HttpStatus.OK);
		} catch (NullPointerException ex) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/all")
	private ResponseEntity<Object[]> findAll() {
		try {
			Object[] books_xxx = bookService.findAll();
			return new ResponseEntity<>(books_xxx, HttpStatus.OK);
		} catch (NullPointerException ex) {
			return new ResponseEntity<Object[]>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/test")
	private void testTransaction() {
		bookService.saveBookStore();
	}
}
