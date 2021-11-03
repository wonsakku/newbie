package com.study.exception;

public class RequestFormatException extends Exception{

	public RequestFormatException() {
		super("요청 형식이 잘못되었습니다.");
	}

	public RequestFormatException(String message) {
		super(message);
	}
}
