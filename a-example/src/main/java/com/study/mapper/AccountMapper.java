package com.study.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.study.dto.ResponseAccountDto;
import com.study.vo.AccountVO;

@Mapper
public interface AccountMapper {

	void join(AccountVO accountVO);

	List<ResponseAccountDto> findAllAccounts();

	Optional<ResponseAccountDto> findAccountByAccountId(String accountId);

	
}
