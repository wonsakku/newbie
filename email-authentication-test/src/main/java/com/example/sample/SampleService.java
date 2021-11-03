package com.example.sample;

import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SampleService {

	
	private final String TEST_EMAIL = "yourEmail";
	private final JavaMailSender javaMailSender;
	
	public void emailTest() {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(TEST_EMAIL);
		mailMessage.setSubject("이메일 인증 study~~~");
		
		String msg = "";
		msg += "이메일 인증 테스트입니다";
		mailMessage.setText(msg);
		
		javaMailSender.send(mailMessage);
	}

	public void emailTestMime() {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
//		new MimeMessageHelper(mimeMessage, multipart, encoding) mimeMessage, 파일첨부, encoding
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
			mimeMessageHelper.setTo(TEST_EMAIL);
			mimeMessageHelper.setSubject("이메일 인증 - MIME");
			
			String href = "http://127.0.0.1:8090/authentication?token=" + UUID.randomUUID().toString();
			String msg = "";
			msg += "<h1>이메일 인증</h1>";
			msg += "<h2>회원가입을 원하신다면 아래의 링크를 클릭하세요</h2>";
			msg += "<a href=\"" + href + "\">회원가입</a>";
			
			mimeMessageHelper.setText(msg, true); // true면 html, false면 일반 텍스트
			
			javaMailSender.send(mimeMessage);
		}catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	
	
}















