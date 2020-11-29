package com.example.bookstore.repository;

import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;

@Repository
public interface BookRepository {
	public Book save(Book b);
}
