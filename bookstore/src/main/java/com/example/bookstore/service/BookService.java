package com.example.bookstore.service;

import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Book;

import java.util.List;

@Service
public interface BookService {
	Book save(Book book);
	Book findById(Long id);
	Object findByIdObj(Long id);
	void removeBook(Book book);
	void saveBookStore();
	Object[] findAll();
}
