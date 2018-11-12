package com.example.springmall.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

@Mapper
public interface SampleLoginMapper {
	int login(Sample sample);
}
