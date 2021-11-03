package com.study.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAccountDto {

	private Integer sequenceNo;
	private String accountId;
	private String email;
	private boolean approved;
	private LocalDateTime createdAt;
}
