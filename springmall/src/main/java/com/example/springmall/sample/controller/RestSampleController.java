package com.example.springmall.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmall.sample.vo.Sample;

//뷰를 리턴하지 않고 객체를 리턴한다.
@RestController
public class RestSampleController {	//	REST API
	@RequestMapping(value="/sample/getRestSample")
	public Sample getRestSample() {
		return new Sample(1,"guest","1234");
	}
}
