package com.example.bookstore.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;

import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository{

	private EntityManager em;
	
	@Autowired
	public BookRepositoryImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Book save(Book b) {
		return em.merge(b);
	}

	@Override
	public Book findById(Long id) {
		try {
			String sql = "Select b FROM Book b WHERE b.id = :id";
			Query query = em.createQuery(sql, Book.class);
			query.setParameter("id", id);
			return (Book) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Object findByIdObj(Long id) {
		try {
			String sql = "Select b.id, b.name, s.address FROM Book b" +
					" JOIN Store s ON b.store.id = s.id " +
					" WHERE b.id = :id";
			Query query = em.createQuery(sql);
			query.setParameter("id", id);
			return query.getResultList().toArray()[0];
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void remove(Book book) {
		em.remove(book);
	}

	@Override
	public Object[] findAll() {
		try {
			String sql = "Select b.id, b.name FROM Book b";
			Query query = em.createQuery(sql, Object[].class);
			Object[] list = query.getResultList().toArray();
			return list;
		} catch (NoResultException e) {
			return null;
		}
	}
}
