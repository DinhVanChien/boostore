package com.example.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "USERS")
public class User {
	@Id
	private Integer id;
	private String names;
	public User() {
		super();
	}
	public User(Integer id, String names) {
		super();
		this.id = id;
		this.names = names;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	
}
