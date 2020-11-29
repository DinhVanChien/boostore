package com.example.bookstore.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomeHandlerException {
	private static final Logger logger = Logger.getLogger(CustomeHandlerException.class);
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorRestponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
		logger.error(ex.getMessage());
		return new ErrorRestponse(HttpStatus.NOT_FOUND, ex.getMessage());
	}
	
//	@ExceptionHandler(ErrorException.class)
//	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
//	public ErrorRestponse handlerException(ErrorException ex, WebRequest rq) {
//		logger.error(ex.getMessage());
//		return new ErrorRestponse(HttpStatus.NOT_FOUND, ex.getMessage());
//	}
	
	
	 // Xử lý tất cả các exception chưa được khai báo
	@ExceptionHandler(ErrorException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorRestponse handlerException(Exception ex, WebRequest req) {
        // Log err
		logger.error(ex.getMessage());
        return new ErrorRestponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}
