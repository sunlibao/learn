package com.sys.web.controller.util;

public class ApiDemand extends Demand {
	
	private Object data;

	/**
	 * jsonp
	 */
	private String callback;
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}
	
	
	

}
