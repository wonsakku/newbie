## Postgresql 데이터 베이스 설정(with docker)

<br>

### docker 설치

```
# yum update -y
# yum -y install yum-utils device-mapper-persistent-data lvm2
# yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo 
# yum install -y docker-ce docker-ce-cli containerd.io
```

<br>

### docker-compose 설치
```
# curl -L "https://github.com/docker/compose/releases/download/1.25.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

# chmod +x /usr/local/bin/docker-compose
# docker-compose --version
```

<br>

### 방화벽 open(openstack 사용 시 보안그룹에서 postgresql 포트(5432)를 추가해준다.)
```
# firewall-cmd --permanent --zone=public --add-port=5432/tcp
# firewall-cmd --reload
# firewall-cmd --list-all
```

<br>

### docker-compose.yml 작성
```
# mkdir postgresql
# cd postgresql
# vi docker-compose.yml


version: "2"
services:
    db:
        image: postgres:latest
        container_name: postgres
        restart: always
        ports:
            - "5432:5432"
        environment:
            POSTGRES_USER: postgres
            POSTGRES_PASSWORD: "0000"
        volumes:
            - /home/postgres/data/:/var/lib/postgresql/data

```

<br>

### docker 실행

```
#  systemctl restart docker
```

<br>

### docker-compose 실행

```
(docker-compose.yml을 작성한 디렉토리(postgresql)에서 실행)
# docker-compose up -d
```

### pgadmin OR aqua 등 DB tool로 DB에 접속

<br>

### init.sql 실행

<br>

___


## 프로젝트 설명

1. application.yml

```yml
server:
  port: 8080 #서버 포트

spring:
  datasource: #데이터베이스 설정
    url: jdbc:postgresql://192.168.10.139:5432/postgres
    username: postgres
    password: '0000'
    driver-class-name: org.postgresql.Driver
  jackson:
    property-naming-strategy: SNAKE_CASE #requsetBody, responseBody의 변수명을 snake_case에서 camelCase로  또는 camelCase에서 snake_case로 매핑해준다.
    
    
mybatis:
  type-aliases-package: com.study.* #mapper를 매핑할 패키지의 위치
  configuration:
    map-underscore-to-camel-case: true #컬럼명에서 under_score인 부분을 camelCase로 매핑해준다.
  mapper-locations:
  - classpath:com.study.mapper.*.xml
```

2. com.study.config.BeanConfig

```
스프링 부트 프로젝트 시작 시  
@SpringBootApplication이 있는 클래스과 @Configuration이 있는 클래스의  
@Bean을 스프링이 관리하는 Bean으로 등록해주고  
이 Bean을 다른 클래스에서 주입받을 수 있다.
```

3. ModelMapper

```
ex> AccountVO accountVO = modelMapper.map(accountDto, AccountVO.class);

AccountDto의 변수명과 AccountVO의 변수명이 비교해서 변수명이 같은 곳에 
AccountDto의 값을 대입해 AccountVO를 생성한다.
```

4. com.study.common.CommonExceptionHandler

```
@ControllerAdvice는 Controller 이후의 작업을 처리하는데
@ExceptionHandler로 예외처리를 일관되게 해줄 수 있다.
```

5. @RequiredArgsConstructor와 생성자 주입

```java
스프링 4.3(?) 버전부터 생성자 주입을 지원한다.
생성자 주입은 클래스의 생성자가 1개이고, 생성자의 파라미터에 Bean으로 등록된 클래스(?)가 있는 경우
Bean을 주입해준다.(즉, 변수 위에 하나씩 @Autowired를 붙일 필요가 없다.)

@RequiredArgsConstructor는 lombok에서 지원해주는 애노테이션인데
변수에 final이 붙어 있는 변수들만을 파라미터로 가지는 생성자를 만들어(?)준다.

따라서 생성자 주입으로 객체를 주입받을 경우 아래와 같이 하면 된다.

@RequiredArgsConstructor
@Service
public class AccountService {

	private final ModelMapper modelMapper;
	private final AccountMapper accountMapper;
    ...
}	

```

6. JSR-303, JSR-380, @Valid, Errors

> JSR-303, JSR-380 [참고 페이지1](https://programmingrecoding.tistory.com/33), [참고 페이지2](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte2:ptl:jsr303)

```java

com.study.controller.AccountController

객체 앞에 @Valid를 넣으면 JsoinAccountDto에 설정한대로 입력값을 검증한다.
JoinAccountDto가 JSR-303,380에 맞지 않는 경우 errors.hasErrors()가 true가 된다.

	@PostMapping("/accounts")
	public ResponseEntity<ResponseDto<JoinAccountDto>> join(@RequestBody @Valid JoinAccountDto accountDto, Errors errors) throws Exception{

		if(errors.hasErrors()) {
			throw new RequestFormatException();
		}

		accountService.join(accountDto);

		ResponseDto<JoinAccountDto> responseDto = new ResponseDto<>();
		responseDto.setResponseDto(StatusConstant.CREATED, null);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
	}
```

___

## 요구사항

1. Client에서 데이터를 받을 경우(RequestBody)나 응답(ResponseBody)을 보낼 경우 DTO를 이용한다.
2. 데이터베이스에 insert할 경우나 update를 할 경우 VO를 이용한다.(modelMapper를 이용해서 dto를 vo로 변환.)
3. 데이터베이스에서 select를 할 경우 DTO를 이용한다.
4. RequestBody를 받을 경우 데이터를 snake_case로 받는다.(jackon설정에 의해 camelCase로 RequestBody에 매핑된다.)

___

## 구현할 것

1. 사용자(account) 리스트 및 상세보기 페이지 만들기
2. 게시글(board) CRUD
3. 게시글(board) 리스트 및 상세보기 페이지 만들기
4. 댓글(comment) CRUD
5. 게시글 상세보기 아래에 댓글(comment) 추가하기
6. 로그인 
    * DB에서 사용자 ID 조회 후 해당 아이디가 있으면 password 비교
      * password가 일치하면  사용자 ID를 session에 넣는다.
      * password가 일치하지 않으면 예외를 던진다.
    * DB에서 사용자 ID가 없으면 예외를 던진다.
7. 접근 제한(interceptor 사용)
    * 로그인 상태 & 로그아웃 상태에서 board 조회, comment 조회 가능
    * 로그인 상태일 때만 board, comment에 글쓰기 가능
8. email 인증 후 approved를 true로 변경
9. login_fail_count가 5를 넘을 경우 1시간 후 로그인 가능하도록 로그인 제한
    * 로그인이 성공하면 longin_fail_count를 0으로 리셋




