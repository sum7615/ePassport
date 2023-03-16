package com.passport.dto;

import org.springframework.http.HttpStatus;



public class ErrorMessage {
	
	private HttpStatus status;
	private String message;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorMessage [httpStatus=" + httpStatus + ", message=" + message + "]";
	}
	
	

}
