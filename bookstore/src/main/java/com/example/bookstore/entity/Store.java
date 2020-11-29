package com.example.bookstore.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store")
@EntityListeners(AuditingEntityListener.class)
public class Store extends Auditable<String> implements Serializable {
	private static final long serialVersionUID = -7376952695622015725L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "address")
	private String address;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store")
//	@JsonIgnore
	private Set<Book> books;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "store1")
	@JsonIgnore
	private Set<Book> books2;
	
}
