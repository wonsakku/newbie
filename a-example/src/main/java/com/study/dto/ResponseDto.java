package com.study.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.study.constant.StatusConstant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {

	private int statusCode;
	private String msg;
	private T data;

	public void setResponseDto(StatusConstant statusConstant, T data) {
		this.statusCode = statusConstant.getStatusCode();
		this.msg = statusConstant.getMsg();
		this.data = data;
	}
}
