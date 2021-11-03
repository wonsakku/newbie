package com.example.mybatisexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatisexample.dto.BoardDto;
import com.example.mybatisexample.dto.ResponseBoardDto;
import com.example.mybatisexample.mapper.TestMapper;

@RestController
public class TestController {
	
	@Autowired
	private TestMapper mapper;
	
	
	@GetMapping("/mybatis/1-n-mapping/test")
	public List<ResponseBoardDto> test01(){
		List<ResponseBoardDto> list = mapper.test01();
		return list;
	}
	
	
	@GetMapping("/mybatis/sort/grade")
	public List<BoardDto> gradeSort(){
		List<BoardDto> list = mapper.gradeSort();
		return list;
	}
}
