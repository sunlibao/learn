package com.sys.web.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONObject;
import com.sys.dto.LoginDto;
import com.sys.service.login.LoginService;
import com.sys.vo.dto.login.LoginDTO;
import com.sys.vo.user.UserVo;
import com.sys.web.controller.util.ApiDemand;
import com.sys.web.controller.util.BillModel;
import com.sys.web.controller.util.Global;
import com.sys.web.controller.util.ParamUtil;
import com.sys.web.controller.util.ReturnCode;
import com.sys.web.controller.util.UserCacheManger;

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
	@ResponseBody
	public ApiDemand toLogin(HttpServletRequest request){
		
		ApiDemand apiDemand = new ApiDemand();
		
		apiDemand.setCode(ReturnCode.NOTRIGHT.getCode());
		apiDemand.setMsg(ReturnCode.NOTRIGHT.getName());
		
		
		return apiDemand;
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
	
	
	
	/**
	 * 跳转到登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/sys/login/toIndex")
	@ResponseBody
	public ApiDemand  toIndex(HttpServletRequest request,HttpServletResponse response) {
		
    	ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			Map<String,Object> resMap = new HashMap<String, Object>();
			
			 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
		                .getAttribute("SPRING_SECURITY_CONTEXT");
		        // 登录名
		        System.out.println("Username:" + securityContextImpl.getAuthentication().getName());
		        // 登录密码，未加密的
		        System.out.println("Credentials:" + securityContextImpl.getAuthentication().getCredentials());
		       
		        WebAuthenticationDetails details = (WebAuthenticationDetails) securityContextImpl.getAuthentication()
		                .getDetails();
		        
	        // 获得访问地址
	        System.out.println("RemoteAddress" + details.getRemoteAddress());
	        // 获得sessionid
	        System.out.println("SessionId" + details.getSessionId());
	        
			LoginDto loginDto = new LoginDto();
			
			loginDto.setKey(details.getSessionId()==null?request.getParameter("jsessionid"):details.getSessionId());
			loginDto.setUsername(securityContextImpl.getAuthentication().getName());
			
			
        	apiDemand.setData(loginDto);
        	apiDemand.setCode(ReturnCode.SUCCESS.getCode());
    		apiDemand.setMsg(ReturnCode.SUCCESS.getName());
    		
    	}catch(Exception e){
    		apiDemand.setCode(ReturnCode.ERROR.getCode());
    		apiDemand.setMsg(ReturnCode.ERROR.getName());
    		e.printStackTrace();
    	}
		
		return apiDemand;
		
    	}
	
	
	
	/**
	 * 退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/system/login/logout")
	@ResponseBody
	public ApiDemand  logout(HttpServletRequest request,HttpServletResponse response) {
		
    	ApiDemand apiDemand = new ApiDemand();
    	
		try{
        	
        	apiDemand.setCode(ReturnCode.SUCCESS.getCode());
    		apiDemand.setMsg(ReturnCode.SUCCESS.getName());
    		
    	}catch(Exception e){
    		apiDemand.setCode(ReturnCode.ERROR.getCode());
    		apiDemand.setMsg(ReturnCode.ERROR.getName());
    		e.printStackTrace();
    	}
		
		return apiDemand;
		
    	}
	

}
