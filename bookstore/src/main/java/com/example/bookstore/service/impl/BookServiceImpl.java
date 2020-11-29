package com.example.bookstore.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	@Transactional
	public Book save(Book b) {
		if(b.getName().equals("chien")) {
			return bookRepository.save(b);
		}
		
		throw new NotFoundException("khoong ton tai ten la chien");
	}
	
}
