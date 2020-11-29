package com.example.bookstore.nativequery;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;

@Repository
public class BookNative {
	@Autowired
	private EntityManager entityManager;
	
	public List<Book> findGrouByStore() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from book where price in (select price "
				+ "from book group by price )");
		List<Book> books = entityManager.createNativeQuery(sql.toString(), Book.class).getResultList();
		return books;
	}
	
	
}
