package com.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.front.service.MyFrontService;
import com.front.vo.Customer;




@Controller
public class LoginFrontController {

	@Autowired
	private MyFrontService FrontService;
	
	//前台跳转到登录页面
	@RequestMapping("/front/login")
	public ModelAndView toLogin(HttpServletRequest request){
		
		//要求登录前的另一个地址
		String url = request.getParameter("url");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/front/login");
		
		//地址传递
		modelAndView.addObject("url", url);
		
		return modelAndView;
	}
	
	
	//注销登录
	@RequestMapping("/front/loginOut")
	public ModelAndView loginOut(HttpServletRequest request){

		request.getSession().setAttribute("LoginCustomer", null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/front/index");
		
		return modelAndView;
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/front/login/login")
	public ModelAndView login(HttpServletRequest request){
		
		//用户名
		String userName = request.getParameter("userName");
		//密码
		String password = request.getParameter("password");
		//跳转地址
		String url = request.getParameter("url");
		
		
		String errorMessage = "";
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(StringUtils.isBlank(userName)){
			errorMessage = "用户名不能为空";
		}else if(StringUtils.isBlank(password)){
			errorMessage = "密码不能为空";
		}else{
			
			List<Customer> customerList =  this.FrontService.findCustomerByUserName(userName);
			
			if(customerList.size() > 0){
				Customer customer =  customerList.get(0);
				if(password.equalsIgnoreCase(customer.getPassword())){
					request.getSession().setAttribute("LoginCustomer", customer);
				}else{
					errorMessage = "密码不正确";
				}
			}else{
				errorMessage = "当前账户不存在";
			}
			
		}
		
		if(StringUtils.isNotBlank(errorMessage)){
			modelAndView.setViewName("front/login");
			modelAndView.addObject("url", url);
			modelAndView.addObject("errorMessage", errorMessage);
		}else{
			if(StringUtils.isBlank(url)){
				url = "front/index";
			}
			
			modelAndView.setViewName(url);
			
		}
		
		
		return modelAndView;
	}
	
	
		//前台跳转到登录页面
		@RequestMapping("/toAdmin")
		public ModelAndView toAdmin(HttpServletRequest request){
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin");
			
			return modelAndView;
		}
		
		//前台跳转到登录页面
		@RequestMapping("/toOther")
		public ModelAndView toOther(HttpServletRequest request){
			
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("shares/sharesIndex");
			
			
			return modelAndView;
		}
	
	
	
}
