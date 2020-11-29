package com.example.bookstore.dto;

public class StoreDto {
	private int limit;
	private int offset;
	private String name;
	
	public StoreDto() {
		super();
	}
	public StoreDto(int limit, int offset, String name) {
		super();
		this.limit = limit;
		this.offset = offset;
		this.name = name;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
