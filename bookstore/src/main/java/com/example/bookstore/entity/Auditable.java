package com.example.bookstore.entity;

import java.sql.Timestamp;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<T> {
	@CreatedBy
	private T createBy;
	@LastModifiedBy
	private T lastModifiedBy;
	@CreatedDate
	private Timestamp createDate;
	@LastModifiedDate
	private Timestamp lastModifiedDate;
	
	
	public Auditable() {
		super();
	}
	public Auditable(T createBy, T lastModifiedBy, Timestamp createDate, Timestamp lastModifiedDate) {
		super();
		this.createBy = createBy;
		this.lastModifiedBy = lastModifiedBy;
		this.createDate = createDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	public T getCreateBy() {
		return createBy;
	}
	public void setCreateBy(T createBy) {
		this.createBy = createBy;
	}
	public T getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(T lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
