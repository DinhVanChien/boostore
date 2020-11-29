package com.example.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Store;
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
	Store save(Store store);
	@Query(value = "CALL `bookstore`.TEST_SP();", nativeQuery = true)
    List<Store> getAllStore();
}
