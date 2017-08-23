package com.sys.dto.permission;

/**
 * 权限DTO
 * @author sunlibao
 *
 */
public class PermissionDTO  {
	
	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 菜单名称
	 */
	private String menuName;

	
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

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	

}
