package com.example.bookstore.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable{

	private static final long serialVersionUID = -179746707541192690L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(name="BookSeq",sequenceName="BOOK_SEQ", allocationSize=1)
	private Long id;
	private String name;
	private String author;
	private float price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	@JsonIgnore
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Store store;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id1")
	@JsonIgnore
	private Store store1;

	public Book(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
