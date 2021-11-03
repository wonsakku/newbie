package com.example.sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SampleController {

	private final SampleService sampleService;
	
	
	@GetMapping("/email/test")
	public ResponseEntity<String> emailTest() {
		try {
			sampleService.emailTest();
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("send");
	}
	
	@GetMapping("/email/test/mime")
	public ResponseEntity<String> emailTestMime() {
		try {
			sampleService.emailTestMime();
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("send");
	}
	
	@GetMapping("/authentication")
	public ResponseEntity<String> authentication(@RequestParam(name = "token", required = true) String token){
		return ResponseEntity.status(HttpStatus.OK).body(token);
	}
	
}
