package com.study.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.study.dto.JoinAccountDto;
import com.study.dto.ResponseAccountDto;
import com.study.exception.AlreadyExistAccountException;
import com.study.exception.NoAccountException;
import com.study.mapper.AccountMapper;
import com.study.vo.AccountVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountService {

	private final ModelMapper modelMapper;
	private final AccountMapper accountMapper;


	public void join(JoinAccountDto accountDto) throws Exception {
		AccountVO accountVO = modelMapper.map(accountDto, AccountVO.class);
		try {
			accountVO.allotAuthenticaionToken();
			accountMapper.join(accountVO);
		} catch (DuplicateKeyException e) {
			throw new AlreadyExistAccountException();
		}
	}


	public List<ResponseAccountDto> findAllAccounts() throws Exception {
		List<ResponseAccountDto> accounts = accountMapper.findAllAccounts();

//		List<ResponseAccountDto> result = accounts.stream()
//				.map(account -> modelMapper.map(account, ResponseAccountDto.class))
//				.collect(Collectors.toList());

		return accounts;
	}


	public ResponseAccountDto findAccountByAccountId(String accountId) throws NoAccountException {

//		AccountVO accountVO = accountMapper.findAccountByAccountId(accountId)
//				.orElseThrow(() -> new NoAccountException("해당 accountId는 존재하지 않습니다."));
//		ResponseAccountDto account = modelMapper.map(accountVO, ResponseAccountDto.class);

		ResponseAccountDto account = accountMapper.findAccountByAccountId(accountId)
				.orElseThrow(() -> new NoAccountException());

		return account;
	}

}
