package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Store;
import com.example.bookstore.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	private StoreRepository storeRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository,
						   StoreRepository storeRepository) {
		this.bookRepository = bookRepository;
		this.storeRepository = storeRepository;
	}

	@Override
	public Book save(Book b) {
		return bookRepository.save(b);
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	public Object findByIdObj(Long id) {
		return bookRepository.findByIdObj(id);
	}

	@Override
	public void removeBook(Book book) {
		bookRepository.remove(book);
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void saveBookStore() {
		Store store = new Store();
		store.setAddress("Hồ Chí Minh");
		storeRepository.save(store);
		Book book = new Book();
		book.setName("SpringBoot2");
		book.setAuthor("Đinh Văn Chiến");
		book.setPrice(200000);
		int a = 2/0;
		System.out.println(a);
		bookRepository.save(book);
	}

	@Override
	public Object[] findAll() {
		return bookRepository.findAll();
	}
}
