package com.example.bookstore.repository;

import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;

import java.util.List;

@Repository
public interface BookRepository {
	Book save(Book b);
	Book findById(Long id);
	Object findByIdObj(Long id);
	void remove(Book book);
	Object[] findAll();
}
