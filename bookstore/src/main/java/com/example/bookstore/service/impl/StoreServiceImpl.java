package com.example.bookstore.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Store;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.StoreRepository;
import com.example.bookstore.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {
	private StoreRepository storeRepository;
	private BookRepository bookRepository;
	@Autowired
	public StoreServiceImpl(StoreRepository storeRepository,
			BookRepository bookRepository) {
		this.storeRepository = storeRepository;
		this.bookRepository = bookRepository;
	}
	@Override
	@Transactional
	public void insertStore(Store store) {
		
		if(store.getBooks() != null) {
			storeRepository.save(store);
			for(Book b : store.getBooks()) {
				b.setStore(store);
				bookRepository.save(b);
			}
		}
	}

}
