package com.example.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 사용자 등록 및 조회 class
 */
public class AccountInfo {

	public static AccountInfo instance;
	private static List<Account> accountInfo;

	private AccountInfo() {
		accountInfo = new ArrayList<>();
		Account account = new Account("id01", "pwd01");
		accountInfo.add(account);

		account = new Account("id02", "pwd02");
		accountInfo.add(account);
		
		account = new Account("id03", "pwd03");
		accountInfo.add(account);
	}
	
	
	public static AccountInfo getInstance(){
		if(instance == null) {
			synchronized (AccountInfo.class) {
				if(instance == null) {
					instance = new AccountInfo();
				}
			}
		}
		return instance;
	}

	
	public static List<Account> getAccountInfo() {
		return accountInfo;
	}
	
}


