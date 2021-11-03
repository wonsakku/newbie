package com.example.sample;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

	
	
	public void login(LoginDto loginDto, HttpServletRequest request) throws RuntimeException{
		
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("id") != null) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(session.getAttribute("id"));
			throw new AlreadyLoginException(); 
		}
		
		List<Account> accounts = AccountInfo.getInstance().getAccountInfo();
		String loginId = loginDto.getId();
		Account enrolled = accounts.stream()
				.filter(account -> loginId.equals( account.getId() ) )
				.findFirst()
				.orElseThrow(() -> new NoAccountException());
						
		if(! (enrolled.getPassword()).equals(loginDto.getPassword()) ) {
			throw new NoAccountException();
		}
		
		session.setAttribute("id", loginId);
	}
	
	

}
