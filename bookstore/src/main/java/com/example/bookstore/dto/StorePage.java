package com.example.bookstore.dto;

import java.util.List;

import com.example.bookstore.entity.Store;

public class StorePage {
	private List<Store> store;
	private int totalPage;
	private int startPage;
	private int endPage;
	public List<Store> getStore() {
		return store;
	}
	public void setStore(List<Store> store) {
		this.store = store;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public void setEndPageYYYYYYY(int endPage) {
		this.endPage = endPage;
	}
}
