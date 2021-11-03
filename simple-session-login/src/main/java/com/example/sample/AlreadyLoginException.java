package com.example.sample;

public class AlreadyLoginException extends RuntimeException{

	public AlreadyLoginException() {
		super("현재 로그인 중입니다.");
	}
	

}
