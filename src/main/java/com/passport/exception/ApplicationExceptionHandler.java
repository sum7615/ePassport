package com.passport.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
	    BindingResult result = ex.getBindingResult();
	    List<FieldError> fieldErrors = result.getFieldErrors();
	    StringBuilder errorMessage = new StringBuilder();
	    for (FieldError fieldError : fieldErrors) {
	        String fieldName = fieldError.getField();
	        String errorMessageText = fieldError.getDefaultMessage();
	        errorMessage.append(fieldName).append(": ").append(errorMessageText).append("\n");
	    }
	    return ResponseEntity.badRequest().body(errorMessage.toString());
	}

}
