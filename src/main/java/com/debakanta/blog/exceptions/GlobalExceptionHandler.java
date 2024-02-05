package com.debakanta.blog.exceptions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.debakanta.blog.payload.ApiResponce;

@ControllerAdvice
public class GlobalExceptionHandler {
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> handeleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach(err->{
//			String fieldName = ((FieldError)err).getField();
//			String errorMessage = err.getDefaultMessage();
//			errors.put(fieldName, errorMessage);
//		});
//		return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> handleResourceNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponce apiResponce = new ApiResponce(message, false);
		return new ResponseEntity<>(apiResponce,HttpStatus.NOT_FOUND);
	}

}
