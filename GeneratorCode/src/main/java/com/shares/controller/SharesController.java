package com.shares.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SharesController {
	
	@RequestMapping("shares/sharesIndex")
	public ModelAndView sharesIndex(HttpServletRequest request){
		
		
		ModelAndView modelAndView = new ModelAndView("shares/sharesIndex");
		
		
		return modelAndView;
	}

}
