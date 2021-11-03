package com.study.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JoinAccountDto {

	@NotNull(message = "아이디는 필수값입니다.")
	@Size(min = 4, message = "아이디는 4글자 이상으로 입력해야 합니다.")
	private String accountId;

	@NotNull
	@Size(min = 4, message = "비밀번호는 4글자 이상으로 입력해야 합니다.")
//	@Pattern(regexp = )
	private String accountPassword;
	
	@NotNull
	@Email
	private String email;
}
