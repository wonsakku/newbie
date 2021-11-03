 --drop table account;
 --drop table board;
 --drop table comment;
 --drop sequence account_sequence;
 --drop sequence board_sequence;
 --drop sequence comment_sequence;

create sequence account_sequence;
create sequence board_sequence;
create sequence comment_sequence;

create table account(
    sequence_no INTEGER DEFAULT NEXTVAL('account_sequence'), --일련번호
    account_id VARCHAR(15) NOT NULL UNIQUE, -- 계정
    email VARCHAR(100) NOT NULL, -- 이메일 인증 
    account_password VARCHAR(255) NOT NULL, -- 비밀번호
    authentication_token VARCHAR(100), -- 인증 토큰
    approved BOOLEAN NOT NULL DEFAULT FALSE, -- 사용승인여부
    login_fail_count INTEGER DEFAULT 0, -- 로그인 실패 횟수
    last_fail_time TIMESTAMP, -- 로그인 실패 시간, 로그인 5회 실패 시 로그인 시간 제한
    last_login_time TIMESTAMP, -- 마지막 로그인 시간
    created_at TIMESTAMP NOT NULL, -- 생성일자
    modify_at TIMESTAMP NOT NULL, -- 변경일자
    CONSTRAINT account_primary_key PRIMARY KEY("sequence_no")
); 

create table board(
    sequence_no INTEGER DEFAULT NEXTVAL('board_sequence'), -- 일련번호
    account_sequence_no INTEGER NOT NULL, -- 게시글 등록자 일련번호
    title VARCHAR(100) NOT NULL, -- 게시글 제목
    content VARCHAR(1000) NOT NULL, -- 게시글 내용
    view_count INTEGER DEFAULT 0, -- 조회수
    created_at TIMESTAMP NOT NULL, -- 생성일자
    modify_at TIMESTAMP NOT NULL, -- 변경일자
    CONSTRAINT board_primary_key PRIMARY KEY("sequence_no")
); 

create table comment(
    sequence_no INTEGER DEFAULT NEXTVAL('comment_sequence'), -- 일련변호
    account_sequence_no INTEGER NOT NULL, -- 댓글 작성자 일련번호
    board_sequence_no INTEGER NOT NULL, -- 게시글 일련번호
    comment VARCHAR(200) NOT NULL, -- 댓글
    grade INTEGER NOT NULL, -- 평점
    created_at TIMESTAMP NOT NULL, -- 생성일자
    modify_at TIMESTAMP NOT NULL, -- 변경일자
    CONSTRAINT comment_primary_key PRIMARY KEY("sequence_no")
); 














