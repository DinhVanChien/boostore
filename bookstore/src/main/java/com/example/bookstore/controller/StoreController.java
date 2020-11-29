package com.example.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.dto.PageDto;
import com.example.bookstore.dto.ResponseBase;
import com.example.bookstore.dto.StoreDto;
import com.example.bookstore.dto.StorePage;
import com.example.bookstore.entity.Store;
import com.example.bookstore.exception.ErrorException;
import com.example.bookstore.nativequery.StoreNative;
import com.example.bookstore.repository.StoreRepository;
import com.example.bookstore.repository.sp.StoredProcedure;
import com.example.bookstore.service.StoreService;

import javassist.NotFoundException;

@RestController
public class StoreController {
	private StoreRepository storeRepository;
	private StoreService storeService;
	private StoredProcedure storeSP;
	private StoreNative storeNative;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final Logger logger = Logger.getLogger(StoreController.class);

	@Autowired
	public StoreController(StoreRepository storeRepository, StoredProcedure storeSP,
			StoreNative storeNative, StoreService storeServic) {
		this.storeRepository = storeRepository;
		this.storeSP = storeSP;
		this.storeNative = storeNative;
		this.storeService = storeServic;
	}

	@PostMapping("/stores")
	public ResponseBase insert(@RequestBody Store store) {
		
		try {
			storeService.insertStore(store);
		} catch (Exception e) {
			new ErrorException(e.getMessage());
			return new ResponseBase("Them that bai", "0");
		}
		logger.info("Success");
		return new ResponseBase();
	}

	@GetMapping("/all")
	public ResponseEntity<List<Store>> findAll() {
		List<Store> stores = storeRepository.findAll();
		return ResponseEntity.ok(stores);

	}

	@GetMapping("/all/name")
	public ResponseEntity<List<Store>> findName() {
		List<Store> stores = storeSP.findByUserName();
		return ResponseEntity.ok(stores);

	}

	@PostMapping("/all/{page}")
	public ResponseEntity<StorePage> findAll(@PathVariable Integer page, @RequestBody StoreDto storeDto) {

		int totalStore = storeNative.totalStore(storeDto);
		StorePage storePage = new StorePage();
		totalStore = 0;
		if (totalStore != 0) {
			PageDto pageDto = new PageDto(totalStore, page, 3);
			storeDto.setOffset(this.offset(storeDto.getLimit(), page));
			List<Store> stores = storeNative.stores(storeDto);
			storePage.setStore(stores);
			storePage.setEndPage(pageDto.getEndPage());
			storePage.setStartPage(pageDto.getStartPage());
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(storePage);
	}

	@PostMapping("/all/t/{page}")
	public ResponseBase test2(@PathVariable Integer page, @RequestBody StoreDto storeDto) {

		int totalStore = storeNative.totalStore(storeDto);
		StorePage storePage = new StorePage();
		totalStore = 0;
		if (totalStore != 0) {
			PageDto pageDto = new PageDto(totalStore, page, 3);
			storeDto.setOffset(this.offset(storeDto.getLimit(), page));
			List<Store> stores = storeNative.stores(storeDto);
			storePage.setStore(stores);
			storePage.setEndPage(pageDto.getEndPage());
			storePage.setStartPage(pageDto.getStartPage());
		} else {

			return new ResponseBase("Khoong co ban ghi", "0");
		}

		return new ResponseBase();
	}

	@GetMapping("/search")
	public ResponseEntity<List<Store>> seachStore() throws NotFoundException {
		List<Store> stores = new ArrayList<Store>();
		try {
			stores = storeNative.searchStore();
		} catch (Exception e) {
			throw new NotFoundException(e.getMessage());
		}

		return ResponseEntity.ok(stores);
	}

	public int offset(int limit, int page) {
		if (1 == page) {
			return 0;
		} else {
			return limit * (page - 1) + 1;
		}
	}
}
