package com.study.vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseVO {

	private Integer sequenceNo;
	private LocalDateTime createdAt;
	private LocalDateTime modifyAt;
}
