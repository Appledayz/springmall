package com.example.springmall.sample.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

@Mapper
public interface SampleMapper {
	//	1. INSERT
	int insertSample(Sample sample);
	//	2. SELECT all
	List<Sample> selectSample(HashMap<String, Integer> pagingInfo);
	//	3. DELETE
	int deleteSample(int sampleNo);
	//	4. UPDATE
	int updateSample(Sample sample);
	//	5. SELECT COUNT(*)
	int selectCountSampleAll();
}