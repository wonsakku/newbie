package com.example.mybatisexample.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCommentDto {

	private int commentSequenceNo;
	private String comment;
	private int grade;
}
