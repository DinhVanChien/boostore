package com.example.bookstore.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -179746707541192690L;
	@Id
	@GeneratedValue(generator="BookSeq") 
	@SequenceGenerator(name="BookSeq",sequenceName="BOOK_SEQ", allocationSize=1) 
	private int id;
	private String name;
	private String author;
	private float price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	//@JsonIgnore
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Store store;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id1")
	@JsonIgnore
	private Store store1;
	public Book() {
	//	super();
	}
	public Book(float price) {
		this.price = price;
	}
	
	public Book(int id, String name, String author, float price, Store store, Store store1) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.store = store;
		this.store1 = store1;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public Store getStore() {
		return store;
	}



	public void setStore(Store store) {
		this.store = store;
	}



	public Store getStore1() {
		return store1;
	}



	public void setStore1(Store store1) {
		this.store1 = store1;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
