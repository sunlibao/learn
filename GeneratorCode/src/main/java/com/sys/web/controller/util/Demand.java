package com.sys.web.controller.util;

import java.io.Serializable;

/**
 * 返回结果
 * @author sunlibao
 *
 */
public class Demand implements Serializable {

	//返回编号
	private String code;
	//返回消息
    private String msg;


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
