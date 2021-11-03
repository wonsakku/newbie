package com.study.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.constant.StatusConstant;
import com.study.dto.JoinAccountDto;
import com.study.dto.ResponseAccountDto;
import com.study.dto.ResponseDto;
import com.study.exception.RequestFormatException;
import com.study.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
public class AccountController {

	private final AccountService accountService;

	@PostMapping("/accounts")
	public ResponseEntity<ResponseDto<JoinAccountDto>> join(@RequestBody @Valid JoinAccountDto accountDto, Errors errors) throws Exception{
//		System.out.println(accountDto);

		if(errors.hasErrors()) {
			throw new RequestFormatException();
		}
		accountService.join(accountDto);

		ResponseDto<JoinAccountDto> responseDto = new ResponseDto<>();
		responseDto.setResponseDto(StatusConstant.CREATED, null);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
	}

	@GetMapping("/accounts")
	public ResponseEntity<ResponseDto<List<ResponseAccountDto>>> findAllAccounts() throws Exception{
		List<ResponseAccountDto> accounts = accountService.findAllAccounts();
		ResponseDto<List<ResponseAccountDto>> responseDto = new ResponseDto<>();
		responseDto.setResponseDto(StatusConstant.OK, accounts);

		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}

	@GetMapping("/accounts/{accountId}")
	public ResponseEntity<ResponseDto<ResponseAccountDto>>
		   findAccountByAccountId(@PathVariable("accountId") String accountId) throws Exception{

		ResponseAccountDto account = accountService.findAccountByAccountId(accountId);
		ResponseDto<ResponseAccountDto> responseDto = new ResponseDto<>();
		responseDto.setResponseDto(StatusConstant.OK, account);

		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
}













