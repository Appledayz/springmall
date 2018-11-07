package com.example.springmall.sample.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService;
	
	//	1. 샘플목록
	@RequestMapping(value="/sample/sampleList", method=RequestMethod.GET)
	public String sampleList(Model model, @RequestParam(value="page", required=false, defaultValue="1") String page) {	//	Model model = new Model();
		HashMap<String, Object> map = sampleService.getSampleList(page);
		List<Sample> sampleList = (List<Sample>) map.get("list"); 
		model.addAttribute("sampleList", sampleList);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPageButton", map.get("lastPageButton"));
		return "/sample/sampleList";
	}
	
	//	2. 삭제
	@RequestMapping(value="/sample/removeSample", method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) {
		if(sampleService.removeSample(sampleNo)==1) {
			System.out.println(sampleNo+"번 데이터 삭제 성공");
		}
		return "redirect:/sample/sampleList";
	}
	
	//	2-1. 입력폼
	@RequestMapping(value="/sample/addSample", method=RequestMethod.GET)
	public String addSample() {
		return "/sample/addSample";
	}
	
	//	2-2. 입력액션
	@RequestMapping(value="/sample/addSample", method=RequestMethod.POST)
	public String addSample(
			@RequestParam(value="id") String id,
			@RequestParam(value="pw") String pw) {
		if(sampleService.addSample(id, pw)==1) {
			System.out.println("입력 완료");
		}
		return "redirect:/sample/sampleList";
	}
}
