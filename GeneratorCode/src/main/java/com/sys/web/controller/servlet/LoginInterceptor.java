package com.sys.web.controller.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sys.web.controller.util.Global;

public class LoginInterceptor  implements HandlerInterceptor  {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		Object loginDTO =  request.getSession().getAttribute(Global.USER_SESSION_KEY);
		
		if (loginDTO == null) {
             System.out.println("尚未登录，调到登录页面");
             response.sendRedirect(request.getContextPath()+"");
             return false;
		}
		
		
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	

	
	

}
