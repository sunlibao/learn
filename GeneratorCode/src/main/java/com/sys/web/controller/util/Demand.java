package com.sys.web.controller.util;

import java.io.Serializable;

/**
 * 返回结果
 * @author sunlibao
 *
 */
public class Demand implements Serializable {

	private String code = ReturnCode.SUCCESS_200;
    private String msg;
    

    public static class ReturnCode {
        /** 业务操作失败，操作全部回滚 **/
        public static final String ERROR_100 = "100";
        /** 业务操作成功 **/
        public static final String SUCCESS_200 = "200";
    }





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
