package com.front.vo;

import java.util.Date;

/**
 * 客户VO
 * @author sunlibao
 *
 */
public class Customer {
	
	private Long id;
	//用户名
	private String userName;
	//密码
	private String password;
	//创建时间
	private Date ctime;
	//修改时间
	private Date utime;
	//0-正常  1-删除
	private int dr;
	//0-正常 1-禁用
	private int state;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Date getUtime() {
		return utime;
	}
	public void setUtime(Date utime) {
		this.utime = utime;
	}
	public int getDr() {
		return dr;
	}
	public void setDr(int dr) {
		this.dr = dr;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
	

}
