package com.study.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.study.constant.StatusConstant;
import com.study.dto.ResponseDto;
import com.study.exception.AlreadyExistAccountException;
import com.study.exception.NoAccountException;
import com.study.exception.RequestFormatException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(RequestFormatException.class)
	public ResponseEntity<ResponseDto> requestFormatException(RequestFormatException e){
		log.error(e.getMessage());
//		ResponseDto responseDto = new ResponseDto<>();
//		responseDto.setResponseDto(StatusConstant.BAD_REEQUEST, null);
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
		return exceptionResponseEntity(StatusConstant.BAD_REQUEST, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AlreadyExistAccountException.class)
	public ResponseEntity<ResponseDto> commonException(AlreadyExistAccountException e){
		log.error(e.getMessage());
//		ResponseDto responseDto = new ResponseDto<>();
//		responseDto.setResponseDto(HttpStatus.BAD_REQUEST.value(),e.getMessage(), null);
		return exceptionResponseEntity(StatusConstant.CONFLICT_ACCOUNT_ID, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(NoAccountException.class)
	public ResponseEntity<ResponseDto> noAccountException(NoAccountException e){
		log.error(e.getMessage());
//		ResponseDto responseDto = new ResponseDto<>();
//		responseDto.setResponseDto(HttpStatus.BAD_REQUEST.value(),e.getMessage(), null);
		return exceptionResponseEntity(StatusConstant.NOT_FOUND, HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<ResponseDto> exceptionResponseEntity(StatusConstant statusConstant, HttpStatus httpStatus){
	  ResponseDto responseDto = new ResponseDto<>();
	  responseDto.setResponseDto(statusConstant, null);
	  return ResponseEntity.status(httpStatus).body(responseDto);
	}



}





