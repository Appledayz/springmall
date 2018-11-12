package com.example.springmall.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value="/sample/login")
	public String login(HttpSession session) {
		session.setAttribute("", "");
		session.getAttribute("");
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/value/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
