package com.rest.calculate.shipping.bean;

public class InvalidInputException extends RuntimeException {
	private static final long serialVersionUID = 3198063490013576878L;

	public InvalidInputException(String message) {
		super(message);
	}
}
