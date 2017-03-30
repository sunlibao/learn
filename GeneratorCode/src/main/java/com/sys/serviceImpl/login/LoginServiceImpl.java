package com.sys.serviceImpl.login;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sys.service.login.LoginService;
import com.sys.service.user.UserService;
import com.sys.vo.dto.login.LoginDTO;
import com.sys.vo.user.UserVo;

/**
 * 登录serviceimpl
 * @author sunlibao
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private JdbcTemplate jTemplate;
	
	@Autowired
	private UserService userService;
	

	@Override
	public LoginDTO login(String username, String password) {
		
		UserVo userVo = userService.findUserByUserName(username);
		
		LoginDTO  loginDTO = new LoginDTO();
		
		if(userVo != null ){
			BeanUtils.copyProperties(userVo, loginDTO);
		}else{
			return null;
		}
		
		
		return loginDTO;
	}
	
	
	

}
