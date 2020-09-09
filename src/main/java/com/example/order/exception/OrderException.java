package com.example.order.exception;

public class OrderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public OrderException() {
		super("No Such Order Id Found. Please enter correct Order Id");
	}

	
}
