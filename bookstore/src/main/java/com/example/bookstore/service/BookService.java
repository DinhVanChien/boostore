package com.example.bookstore.service;

import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Book;

@Service
public interface BookService {
	public Book save(Book b);
}
