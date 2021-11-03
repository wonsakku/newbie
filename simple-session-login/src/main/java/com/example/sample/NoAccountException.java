package com.example.sample;

public class NoAccountException extends RuntimeException{

	public NoAccountException() {
		super("일치하는 정보가 없습니다.");
	}
}
