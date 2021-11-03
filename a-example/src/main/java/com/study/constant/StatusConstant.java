package com.study.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusConstant {

  OK("OK", 2000),
  CREATED("CREATED", 2001),
  ACCEPTED("ACCEPTED", 2002),
  NO_CONTENT("NO_CONTENT", 2004),
  BAD_REQUEST("잘못된 요청입니다.", 4000),
  NOT_FOUND("일치하는 정보가 없습니다.", 4004),
  CONFLICT_ACCOUNT_ID("이미 존재하는 아이디입니다.", 4009),
  INTERNAL_SERVER_ERROR("서버 내 문제가 발생했습니다.", 5000)
  ;

  private String msg;
  private int statusCode;
}
