package com.sys.vo.role;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 角色管理
 * @author sunlibao
 *
 */
@MappedSuperclass
public class RoleVo {
	
	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	/**
	 * 角色名称
	 */
	@Column(name="roleName")
	private String roleName;
	
	/**
	 * 角色编号
	 */
	@Column(name="roleCode")
	private String roleCode;
	
	/**
	 * 说明
	 */
	@Column(name="note")
	private String note;

	/**
	 * 状态   0-正常  1-禁用
	 */
	@Column(name="state")
	private String state;
	
	/**
	 * 插入时间
	 */
	@Column(name="ctime")
	private Date ctime;
	/**
	 * 修改时间
	 */
	@Column(name="utime")
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
