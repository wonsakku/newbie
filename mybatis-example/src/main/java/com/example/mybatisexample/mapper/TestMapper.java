package com.example.mybatisexample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mybatisexample.dto.BoardDto;
import com.example.mybatisexample.dto.ResponseBoardDto;

@Mapper
public interface TestMapper {

	List<ResponseBoardDto> test01();

	List<BoardDto> gradeSort();
}
