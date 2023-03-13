package com.passport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.passport.dto.ErrorMessage;


@RestControllerAdvice
public class ResponsesEntityHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> questionBankNotFoundException(AppointmentNotFoundException exception,
	        WebRequest request) {
	    ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}

}
