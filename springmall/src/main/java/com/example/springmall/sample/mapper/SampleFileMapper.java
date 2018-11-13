package com.example.springmall.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.SampleFile;

@Mapper
public interface SampleFileMapper {
	int insertSampleFile(SampleFile sampleFile);
	List<SampleFile> selectSampleFileDirForDelete(int sampleNo);
	int deleteSampleFile(int sampleNo);
}
