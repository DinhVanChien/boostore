package com.example.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.nativequery.BookNative;

@RestController
@RequestMapping("/native")
public class BookNativeController {
	@Autowired
	private BookNative bookNative;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> listBooks() {
		List<Book> books = new ArrayList<>();
		try {
			books = bookNative.findGrouByStore();
			if(books == null) {
				throw new NotFoundException("Khong ton tai record book");
			}
		} catch (Exception e) {
			throw new NotFoundException(e.getMessage());
		}
		return ResponseEntity.ok(books);
	}
}
