package com.sys.web.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sys.service.login.LoginService;
import com.sys.vo.dto.login.LoginDTO;
import com.sys.web.controller.util.Global;

/**
 * 登录界面
 * @author sunlibao
 *
 */
@Controller
public class LoginController {
	
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("login/login.do")
	public ModelAndView login(HttpServletRequest request){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		/*//判断用户已经登录-跳转到首页
		if(request.getSession().getAttribute(Global.USER_SESSION_KEY) != null){
			ModelAndView modelAndView  = new ModelAndView("/gengrator/index");
			return modelAndView;
		}*/
		
		LoginDTO loginDTO =  loginService.login(username,password);
		
		ModelAndView modelAndView  = new ModelAndView("/gengrator/index");
		
		
		if(loginDTO == null){
			modelAndView.setViewName("/login");
			modelAndView.addObject("errorMsg", "用户名或者密码不正确");
		}else{
			request.getSession().setAttribute(Global.USER_SESSION_KEY, loginDTO);
			
		}
		
		return modelAndView;
	}
	
	
	
	
	/**
	 * 跳转到登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("toLogin.do")
	public ModelAndView toLogin(HttpServletRequest request){
		
		ModelAndView modelAndView  = new ModelAndView("login");
		
		return modelAndView;
	}
	
	
	/**
	 * 跳转到没有权限页面
	 * @param request
	 * @return
	 */
	@RequestMapping("toAccessDenied.do")
	public ModelAndView toAccessDenied(HttpServletRequest request){
		
		ModelAndView modelAndView  = new ModelAndView("accessDenied");
		
		return modelAndView;
	}
	
	
	/**
	 * 跳转到登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("toIndex.do")
	public ModelAndView toIndex(HttpServletRequest request){
		
		ModelAndView modelAndView  = new ModelAndView("index");
		
		return modelAndView;
	}
	
	
	

}
