package com.sys.vo.role;

import java.util.Date;

/**
 * 角色管理
 * @author sunlibao
 *
 */
public class RoleVo {
	
	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色编号
	 */
	private String roleCode;
	
	/**
	 * 说明
	 */
	private String note;

	/**
	 * 状态   0-正常  1-禁用
	 */
	private String state;
	
	/**
	 * 插入时间
	 */
	private Date ctime;
	/**
	 * 修改时间
	 */
	private Date utime;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	
	
	
	
	
}
