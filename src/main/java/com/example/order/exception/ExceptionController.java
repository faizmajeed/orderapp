package com.example.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.FeignException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Object> handleError(RuntimeException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
	}
}
