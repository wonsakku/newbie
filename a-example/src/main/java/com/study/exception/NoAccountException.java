package com.study.exception;

public class NoAccountException extends Exception{

	public NoAccountException() {
		super();
	}

	public NoAccountException(String message) {
		super(message);
	}
}
