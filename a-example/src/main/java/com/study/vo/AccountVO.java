package com.study.vo;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountVO extends BaseVO{

	private String accountId;
	private String email;
	private String accountPassword;
	private String authenticationToken;
	private boolean approved;
	private int loginFailCount;
	private LocalDateTime lastFailTime;
	private LocalDateTime lastLoginTime;
	
	public void approve() {
		this.approved = true;
	}
	
	public void allotAuthenticaionToken() {
		this.authenticationToken = UUID.randomUUID().toString();
	}
}




















