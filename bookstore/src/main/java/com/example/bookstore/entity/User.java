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
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	public void setNamesV3(String names) {
		this.names = names;
	}
=======
<<<<<<< HEAD
=======
>>>>>>> parent of 2d9d764 (Delete User.java)
<<<<<<< HEAD
	public void setNam(String names) {
		this.names = names;
	}
	public void setId***************(Integer id) {
		this.id = id;
	}
=======
	public void setNamesTETTTTT(String names) {
=======
	public void setNamesV3(String names) {
>>>>>>> chiendv
		this.names = names;
	}
>>>>>>> ef05e05 (chiendv)
<<<<<<< HEAD
>>>>>>> parent of 2d9d764 (Delete User.java)
=======
>>>>>>> parent of 2d9d764 (Delete User.java)
=======
	public void setNamesV3(String names) {
		this.names = names;
	}
>>>>>>> aca18514d693ff31445ee39f45c0ed243df5f79e
	
}
