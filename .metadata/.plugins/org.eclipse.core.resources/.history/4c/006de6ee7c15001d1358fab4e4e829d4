package com.customerApp.utils;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customerApp.dto.ErrorInfo;
import com.customerApp.exception.CustomerNotFoundException;

@RestControllerAdvice
public class CustomerAppExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public ErrorInfo handle404(CustomerNotFoundException e) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setError(e.getMessage());
		errorInfo.setMessage("Contact at nikhil.b.sharma@ukg.com");
		errorInfo.setTimestamp(LocalDateTime.now());
		return errorInfo;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorInfo handle400(MethodArgumentNotValidException e) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
		errorInfo.setError(e.getBindingResult().getAllErrors().stream().map(ex -> ex.getDefaultMessage())
				.collect(Collectors.joining(" ")));
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setMessage("Contact at nikhil.b.sharma@ukg.com");
		return errorInfo;
	}
}
