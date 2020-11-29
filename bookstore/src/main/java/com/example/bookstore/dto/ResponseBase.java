package com.example.bookstore.dto;

import java.io.Serializable;

public class ResponseBase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7987830100073747992L;
	private String errorCode = "0";
	private String errorDescription = null;
	private String status = "1"; //succeed, 0: error
	
	public ResponseBase() {
		super();
	}
	public ResponseBase(String errorDescription, String status) {
		super();
		errorCode = "0";
		this.errorDescription = errorDescription;
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
