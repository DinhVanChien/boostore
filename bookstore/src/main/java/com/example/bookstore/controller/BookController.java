package com.example.bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
	private Book insertBook(
							@RequestBody Book book) {
		System.out.println("Test s1: "+ book.getName() + " s2: " +book.getPrice() );
		
		return bookService.save(book);
	}
	
	@PutMapping("/update/{bookId}")
	private String updateBook(@RequestBody Book book, @PathVariable Integer bookId) {
		System.out.println("Test Update Name: "+ book.getName() + " ID: " +book.getId() );
		return book.getName();
	}
	
	@DeleteMapping("/delete")
	private String updateBook(@RequestBody Integer id) {
		System.out.println("Test delete id: "+ id);
		return id.toString();
	}
}
