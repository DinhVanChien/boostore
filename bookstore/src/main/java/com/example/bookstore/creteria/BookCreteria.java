package com.example.bookstore.creteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;

@Repository
public class BookCreteria {
	@Autowired
	private EntityManager em;
	
	public List<Book> findAllBook() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> from = cq.from(Book.class);
		/*Join<Book, Store> st = */from.join("store", JoinType.INNER);
		return em.createQuery(cq).getResultList();
	}
	
	public List<Book> findByIdStore1() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> from = cq.from(Book.class);
		from.join("store1", JoinType.INNER);
		cq.where(cb.equal(from.get("store1"), 1));
		cq.orderBy(cb.desc(from.get("store")), cb.asc(from.get("author"))); // ORDER BY createdAt DESC, fullname ASC
		return em.createQuery(cq).getResultList();
	}
	
	public List<Book> findByIdStore1GroupBy() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> from = cq.from(Book.class);
		//cq.multiselect(from.get("price"))
		cq.groupBy(from.get("price"));//select 1 trường store1
	//	from.join("store1", JoinType.INNER);
		return em.createQuery(cq).getResultList();
	}
}
