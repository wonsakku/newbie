package com.study.exception;

public class AlreadyExistAccountException extends Exception{

	public AlreadyExistAccountException() {
		super("이미 존재하는 아이디입니다.");
	}
	
	public AlreadyExistAccountException(String message){
		super(message);
	}
}


