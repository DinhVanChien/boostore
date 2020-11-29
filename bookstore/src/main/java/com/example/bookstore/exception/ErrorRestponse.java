package com.example.bookstore.exception;

import org.springframework.http.HttpStatus;

public class ErrorRestponse {
	private HttpStatus status;
	private String message;
	
	public ErrorRestponse() {
		super();
	}
	public ErrorRestponse(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return status;
	}
	public void setErrorCode(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
