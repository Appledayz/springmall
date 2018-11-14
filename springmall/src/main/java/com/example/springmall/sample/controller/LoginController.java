package com.example.springmall.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PostMapping("/sample/login")
	public String login(HttpSession session, Sample sample) {
		System.out.println("LoginController.login POST요청");
		if(loginService.login(sample)==1) {
			System.out.println("session S_ID 저장 : "+sample.getSampleId());
			session.setAttribute("S_ID", sample.getSampleId());
			return "redirect:/sample/sampleList";
		}else {
			return "redirect:/sample/login";
		}
	}
	
	
	@RequestMapping(value="/sample/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/sample/sampleList";
	}
}
