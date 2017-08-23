package com.sys.vo.pemission;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 权限VO （角色资源关系表）
 * @author sunlibao
 *
 */
@MappedSuperclass
public class PermissionVo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	/**
	 * 角色ID
	 */
	@Column(name="roleId")
	private Long roleId;
	
	/**
	 * 资源Id
	 */
	@Column(name="resId")
	private Long resId;

	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
