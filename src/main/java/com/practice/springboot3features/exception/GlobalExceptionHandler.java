package com.practice.springboot3features.exception;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(AgeNotValidException.class)
	public ResponseEntity<ProblemDetail> handlerForAgeNotValidEx(AgeNotValidException ex){
		ProblemDetail problemDetail =  ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		problemDetail.setTitle("Age is less than 18 years");
		problemDetail.setDetail("Kindly go for vote if you will be eligible as per government regulations!!");
		problemDetail.setType(URI.create("http://localhost:8080/error"));
		problemDetail.setStatus(500); //problemDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		problemDetail.setProperty("host", "localhost");
		problemDetail.setProperty("port", "8080");
		problemDetail.setProperty("cause", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);	
	}
}
