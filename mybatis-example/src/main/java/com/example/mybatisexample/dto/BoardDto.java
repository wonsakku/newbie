package com.example.mybatisexample.dto;

import lombok.Data;

@Data
public class BoardDto {

	private int boardSequenceNo;
	private String title;
	private String content;
	private int averageGrade;
	private int commentCount;
}

