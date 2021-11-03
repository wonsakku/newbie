create schema test_mybatis;

--drop table test_mybatis.comment;
--drop table test_mybatis.board;
--drop sequence test_mybatis.comment_sequence;
--drop sequence test_mybatis.board_sequence;

create sequence test_mybatis.board_sequence;
create sequence test_mybatis.comment_sequence;


create table test_mybatis.board(
    sequence_no INTEGER DEFAULT NEXTVAL('test_mybatis.board_sequence'), -- 일련번호
    title VARCHAR(100) NOT NULL, -- 게시글 제목
    content VARCHAR(1000) NOT NULL, -- 게시글 내용
    created_at TIMESTAMP NOT NULL, -- 생성일자
    modify_at TIMESTAMP NOT NULL, -- 변경일자
    CONSTRAINT board_primary_key PRIMARY KEY("sequence_no")
); 

create table test_mybatis.comment(
    sequence_no INTEGER DEFAULT NEXTVAL('test_mybatis.comment_sequence'), -- 일련변호
    board_sequence_no INTEGER NOT NULL, -- 게시글 일련번호
    comment VARCHAR(200) NOT NULL, -- 댓글
    grade INTEGER NOT NULL, -- 평점
    created_at TIMESTAMP NOT NULL DEFAULT now(), -- 생성일자
    modify_at TIMESTAMP NOT NULL  DEFAULT now(), -- 변경일자
    CONSTRAINT comment_primary_key PRIMARY KEY("sequence_no")
); 

---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------

-- 원하는만큼 반복(적당히...)
insert into test_mybatis.board(title, content, created_at, modify_at)
values ('테스트 제목_' || (select coalesce(max(sequence_no), 0) from test_mybatis.board) 
        , 'aaa'|| (select coalesce(max(sequence_no), 0) from test_mybatis.board)
        , now()
        , now()
);


-------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------

-- 원하는만큼 반복(적당히...)
insert into test_mybatis.comment(board_sequence_no, comment, grade)
values ((SELECT trunc(random() * (select count(*) from test_mybatis.board))) 
        , 'comment_'|| (SELECT trunc(random() * 10000))
        , (SELECT trunc(random() * 11))
);
