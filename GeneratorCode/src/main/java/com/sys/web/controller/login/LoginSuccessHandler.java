package com.sys.web.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sys.service.login.LoginService;
import com.sys.vo.dto.login.LoginDTO;
import com.sys.web.controller.util.Global;

/**
 * spring secripty 登录成功后调用的类
 * @author sunlibao
 *
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	private LoginService loginService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		
		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");
		
		LoginDTO loginDTO =  loginService.login(username,password);
		
		//设置登录session
		request.getSession().setAttribute(Global.USER_SESSION_KEY, loginDTO);
		
	}

}
