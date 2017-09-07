package com.sys.vo.user;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/** */ 
@MappedSuperclass
public class  UserVo{
 
/** 主键id  */
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private  String id;

/** 用户名  */
@Column(name="username")
private  String username;

/** 密码  */
@Column(name="password")
private  String password;

/** 删除标记 0-正常 1-删除  */
private  Integer dr;


public UserVo() {
	super();
}

public UserVo(String id, String username, String password, Integer dr) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.dr = dr;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Integer getDr() {
	return dr;
}

public void setDr(Integer dr) {
	this.dr = dr;
}





} 