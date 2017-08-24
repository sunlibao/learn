package com.sys.dto;

import com.sys.vo.user.UserVo;

/**
 * 用户登录数据
 * @author sunlibao
 *
 */
public class LoginDto {
	
	/**
	 * 登录标记key
	 */
	private String key;

	/**
	 * 用户名
	 */
	private String username;
	
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
