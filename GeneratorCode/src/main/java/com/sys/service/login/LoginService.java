package com.sys.service.login;

import com.sys.vo.dto.login.LoginDTO;

/**
 * 登录servi
 * @author sunlibao
 *
 */
public interface LoginService {

	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录对象
	 */
	LoginDTO login(String username, String password);

}
