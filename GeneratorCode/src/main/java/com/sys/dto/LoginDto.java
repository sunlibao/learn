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
	 * 用户vo
	 */
	private UserVo userVo;
	
	public LoginDto(String key,UserVo userVo){
		this.key = key;
		this.userVo = userVo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}
	
	

}
