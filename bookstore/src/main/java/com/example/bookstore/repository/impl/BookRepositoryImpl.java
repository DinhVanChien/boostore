package com.example.bookstore.repository.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository{

	private EntityManager em;
	
	@Autowired
	public BookRepositoryImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	@Transactional
	public Book save(Book b) {
		return em.merge(b);
	}
}
