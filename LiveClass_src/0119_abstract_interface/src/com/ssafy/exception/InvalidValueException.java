package com.ssafy.exception;

public class InvalidValueException extends Exception {
	
	public InvalidValueException(int value) {
		super("값이 올바르지 않습니다. : "+value);
	}

}
