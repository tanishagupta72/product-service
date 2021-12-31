package com.ibm.product.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ibm.product.exception.ProductNotFoundException;
import com.ibm.product.model.ErrorResponse;

@RestControllerAdvice
public class ProductServiceAdvice {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Error","Product Not Found",new Date()));
	}
	
}
