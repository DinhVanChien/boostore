package com.example.bookstore.exception;

public class NotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4675910487586630738L;

	public NotFoundException(String message) {
		super(message);
	}
}
