package com.example.springmall.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springmall.sample.service.LoginService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/sample/login")
	public String login() {
		System.out.println("LoginController.login GET요청");
		return "/sample/login";
	}
	
	@RequestMapping(value="/sample/login", method=RequestMethod.POST)
	public String login(HttpSession session, Sample sample) {
		System.out.println("LoginController.login POST요청");
		System.out.println("loginService.login(sample) : "+ loginService.login(sample));
		if(loginService.login(sample)==1) {
			System.out.println("session S_ID 저장 : "+sample.getSampleId());
			session.setAttribute("S_ID", sample.getSampleId());
		}
		return "redirect:/sample/sampleList";
	}
	
	
	@RequestMapping(value="/value/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/sample/sampleList";
	}
}
