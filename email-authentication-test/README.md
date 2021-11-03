# 인증 이메일 테스트 프로젝트입니다.

___

<br>

> application.yml

```yml
spring:
  mail:
    username: gmail smtp 서비스를 등록한 이메일을 입력
    password: smtp 서비스 등록 후 발급받은 key값
```

* 테스트를 위한 email과 password은 네이버 - 내게쓴메일함의 '구글 이메인 인증 정보'에 저장되어 있다.

<br>

___

<br>

> com.example.sample.SampleService의 TEST_EMAIL에 인증 메일을 받을 이메일 주소를 입력하면 된다.

```java
public class SampleService {

	private final String TEST_EMAIL = "email@email.com";
	// private final String TEST_EMAIL = "yourEmail";
	private final JavaMailSender javaMailSender;
	
    ...
}
```