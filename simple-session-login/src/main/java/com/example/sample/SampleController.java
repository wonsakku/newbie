package com.example.sample;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SampleController {

	private final SampleService sampleService;
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginDto loginDto,
			HttpServletRequest request) throws RuntimeException {
		sampleService.login(loginDto, request);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// 현재 등록된 유저 확인
	@GetMapping("/accounts")
	public ResponseEntity<List> users(){
		List accounts = AccountInfo.getInstance().getAccountInfo();
		return ResponseEntity.status(HttpStatus.OK).body(accounts);
	}
	
	// 현재 로그인 중인 아이디 체크
	@GetMapping("/accounts/check")
	public ResponseEntity<String> checkAccount(HttpServletRequest request){
		HttpSession session = request.getSession();
		Object id = session.getAttribute("id");
		
		if(id == null || "".equals(id.toString())) {
			String msg = "현재 로그인된 사용자가 없습니다.";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		}
		
		String strId = id.toString();
		
		return ResponseEntity.status(HttpStatus.OK).body(strId);
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public ResponseEntity logout(HttpServletRequest request) {
		HttpSession session =request.getSession();
		session.invalidate();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
