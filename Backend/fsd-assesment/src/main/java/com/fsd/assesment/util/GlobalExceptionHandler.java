package com.fsd.assesment.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<?> handleConflict(Exception exception, WebRequest webRequest) {
		return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
	}
}
