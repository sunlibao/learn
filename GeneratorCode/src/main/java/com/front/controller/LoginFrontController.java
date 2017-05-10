package com.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFrontController {

	
	//前台跳转到登录页面
	@RequestMapping("/front/login")
	public ModelAndView toLogin(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/front/login");
		
		return modelAndView;
	}
	
	
}
