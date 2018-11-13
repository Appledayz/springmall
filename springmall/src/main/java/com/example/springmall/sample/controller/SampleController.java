package com.example.springmall.sample.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleRequest;

@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService;
	
	//	1. 샘플목록
	@RequestMapping(value="/sample/sampleList", method=RequestMethod.GET)
	public String sampleList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {	//	Model model = new Model();
		System.out.println("SampleController.sampleList GET 요청 받음");
		HashMap<String, Object> map = sampleService.getSampleList(page);
		List<Sample> sampleList = (List<Sample>) map.get("list"); 
		model.addAttribute("sampleList", sampleList);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPageButton", map.get("lastPageButton"));
		model.addAttribute("firstPageButton", map.get("firstPageButton"));
		return "/sample/sampleList";
	}
	
	//	2. 삭제
	@RequestMapping(value="/sample/removeSample", method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) {
		System.out.println("SampleController.removeSample GET 요청 받음");
		int i = sampleService.removeSample(sampleNo);
		if(i>0) {
			System.out.println("삭제한 데이터 ROW : "+i+"개");
			System.out.println("sampleNo : "+sampleNo+"번 데이터 삭제 성공");
		}
		return "redirect:/sample/sampleList";
	}
	
	//	3-1. 입력폼
	@RequestMapping(value="/sample/addSample", method=RequestMethod.GET)
	public String addSample() {
		System.out.println("SampleController.addSample GET 요청 받음");
		return "/sample/addSample";
		//	jquery, bootstrap, Sample command객체
	}
	
	//	3-2. 입력액션
	@PostMapping("/sample/addSample")
	public String addSample(SampleRequest sampleRequest) {
		System.out.println("SampleController.addSample POST 요청 받음");
		//	- Sample 친구들...
		//	command객체의 멤버변수 == input태그 name속성, 표준setter필요
		System.out.println("SampleRequest.multiparFile : "+sampleRequest.getMultipartFile());
		int i = sampleService.addSample(sampleRequest);
		if(i>0) {
			System.out.println("입력 완료 : "+i);
		}
		return "redirect:/sample/sampleList";
	}
	
	//	4-1. 수정폼
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.GET)
	public String modifySample(Model model, @RequestParam(value="sampleNo") int sampleNo) {
		System.out.println("SampleController.modifySample GET 요청 받음");
		Sample sample = sampleService.getSample(sampleNo);
		model.addAttribute("sample", sample);
		return "/sample/modifySample";
	}
	
	//	4-2. 수정액션
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.POST)
	public String modifySample(Sample sample) {
		System.out.println("SampleController.modifySample POST 요청 받음");
		if(sampleService.modifySample(sample)==1) {
			System.out.println("수정 완료");
		}
		return "redirect:/sample/sampleList";
	}
}
