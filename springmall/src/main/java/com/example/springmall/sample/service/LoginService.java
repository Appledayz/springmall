package com.example.springmall.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmall.sample.mapper.SampleLoginMapper;
import com.example.springmall.sample.vo.Sample;

@Service
public class LoginService {
	@Autowired
	private SampleLoginMapper sampleLoginMapper;
	
	public int login(Sample sample) {
		return sampleLoginMapper.login(sample);
	}
}
