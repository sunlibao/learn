package com.sys.vo.permisson;

/**
 * 权限VO （角色资源关系表）
 * @author sunlibao
 *
 */
public class PermissionVo {
	
	/**
	 * 系统主键
	 */
	private Long id;
	
	/**
	 * 角色ID
	 */
	private Long roleId;
	
	/**
	 * 资源Id
	 */
	private Long resId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	

}
