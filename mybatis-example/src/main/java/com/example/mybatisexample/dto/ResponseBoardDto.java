package com.example.mybatisexample.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBoardDto {

	int boardSequenceNo;
	String title;
	String content;
	List<ResponseCommentDto> commentList;
}
