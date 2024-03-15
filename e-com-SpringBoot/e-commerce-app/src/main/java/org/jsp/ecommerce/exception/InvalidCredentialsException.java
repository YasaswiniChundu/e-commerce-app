package org.jsp.ecommerce.exception;

public class InvalidCredentialsException extends RuntimeException{

	public InvalidCredentialsException(String message) {
		super(message);
	}
	
	public InvalidCredentialsException() {
		//Empty Constructor
	}
	
}
