package org.jsp.ecommerce.exception;

public class IdNotFoundException extends RuntimeException{

	public String getMessage() {
		return "Invalid id";
	}
}
