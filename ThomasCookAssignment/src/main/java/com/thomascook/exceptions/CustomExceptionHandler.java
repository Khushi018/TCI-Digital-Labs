package com.thomascook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomExceptionHandler extends RuntimeException {
	public CustomExceptionHandler(String message) {
		 super(message);
	}
   
}
