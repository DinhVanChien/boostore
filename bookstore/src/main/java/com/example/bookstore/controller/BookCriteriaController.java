package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.creteria.BookCreteria;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.ErrorException;
import com.example.bookstore.exception.NotFoundException;

@RestController
@RequestMapping("/criteria")
public class BookCriteriaController {
	@Autowired
	private BookCreteria bookCriteria;
	
	/*
	 * @GetMapping public ResponseEntity<List<Book>> listBook() { List<Book> books =
	 * bookCriteria.findAllBook();
	 * 
	 * if(books == null) { throw new NotFoundException("Khong ton tai record book");
	 * } //return ResponseEntity.ok(books); return new
	 * ResponseEntity<List<Book>>(books, HttpStatus.OK); }
	 */
	
	@GetMapping
	public List<Book> listBook() {
		List<Book> books = bookCriteria.findAllBook();
		
		if(books == null) {
			throw new NotFoundException("Khong ton tai record book");
		}
		//return ResponseEntity.ok(books);
		return books;
	}
	
	@GetMapping("/store1")
	public ResponseEntity<List<Book>> listBookByStore1() throws ErrorException {
		List<Book> books;
		try {
			books = bookCriteria.findByIdStore1();
			
			if(books == null) {
				throw new NotFoundException("Khong ton tai record book");
			}
		} catch (Exception e) {
			throw new NotFoundException("lỗi ngoại lệ rồi");
		}
		
		return ResponseEntity.ok(books);
	}
	
	@GetMapping("/store1/groupby")
	public ResponseEntity<List<Book>> findByIdStore1GroupBy() {
		List<Book> books = bookCriteria.findByIdStore1GroupBy();
			
			if(books == null) {
				throw new NotFoundException("Khong ton tai record book");
			}
		
		
		return ResponseEntity.ok(books);
	}

}
