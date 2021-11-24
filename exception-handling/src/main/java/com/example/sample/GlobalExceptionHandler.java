package com.example.sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> runtimeException(Exception e){
		return errorReponseEntity(HttpStatus.BAD_REQUEST, e);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ExceptionResponse> illegalArgumentException(Exception e){
		return errorReponseEntity(HttpStatus.NOT_ACCEPTABLE, e);
	}
	
	
	@ExceptionHandler(SampleOneException.class)
	public ResponseEntity<ExceptionResponse> sampleOneException(Exception e){
		return errorReponseEntity(HttpStatus.METHOD_NOT_ALLOWED, e);
	}
	
	
	@ExceptionHandler(SampleTwoException.class)
	public ResponseEntity<ExceptionResponse> sampleTwoException(Exception e){
		return errorReponseEntity(HttpStatus.NOT_ACCEPTABLE, e);
	}
	
	

	private ResponseEntity<ExceptionResponse> errorReponseEntity(HttpStatus status, Exception e) {
		ExceptionResponse response = ExceptionResponse.builder()
				.message(e.getMessage())
				.responseCode(status.name())
				.build();
		return ResponseEntity.status(status).body(response);
	}
	
	
}
