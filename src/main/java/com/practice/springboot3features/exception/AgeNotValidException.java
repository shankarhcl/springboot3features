package com.practice.springboot3features.exception;

public class AgeNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public AgeNotValidException(){}
	public AgeNotValidException(String message){super(message);}
}
