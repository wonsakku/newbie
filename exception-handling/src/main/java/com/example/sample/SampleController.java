package com.example.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	
	@GetMapping("/exception-test/{code}")
	public String exceptionHandler1(@PathVariable int code) {
		if(code == 1) {
			throw new SampleOneException();
		}
		if(code == 2) {
			throw new SampleTwoException();
		}
		if(code == 3) {
			throw new RuntimeException("code = 3 -> RuntimeException");
		}
		if(code == 4) {
			throw new IllegalArgumentException("code = 4 -> IllegalArgumentException");
		}
		
		return "process successfully completed";
	}

	@GetMapping("/exception-test/try-catch/{code}")
	public String exceptionHandler2(@PathVariable int code) {
		
		try {
			if(code == 1) {
				throw new SampleOneException();
			}
			if(code == 2) {
				throw new SampleTwoException();
			}
			if(code == 3) {
				throw new RuntimeException("code = 3 -> RuntimeException");
			}
			if(code == 4) {
				throw new IllegalArgumentException("code = 4 -> IllegalArgumentException");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "process successfully completed- try-catch - exceptionHandling on Exception";
	}
	
	
	@GetMapping("/exception-test/try-catch-v2/{code}")
	public String exceptionHandler3(@PathVariable int code) {
		
		try {
			if(code == 1) {
				throw new SampleOneException();
			}
			if(code == 2) {
				throw new SampleTwoException();
			}
			if(code == 3) {
				throw new RuntimeException("code = 3 -> RuntimeException");
			}
			if(code == 4) {
				throw new IllegalArgumentException("code = 4 -> IllegalArgumentException");
			}
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return "process successfully completed - try-catch-v2 - exceptionHandling on IllegalArgumentException";
	}
}










