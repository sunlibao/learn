package com.sys.service.permission;

import java.util.List;

import com.sys.dto.permission.PermissionDTO;
import com.sys.vo.pemission.PermissionVo;

public interface PermissionService {

	/**
	 * 分页查询权限
	 * @param currentPage 当前页
	 * @param pageSize 查询条数
	 * @param roleName 角色名称
	 * @param menuName 菜单名称
	 * @return
	 */
	List<PermissionDTO> findPermissionPage(String currentPage, String pageSize,
			String roleName, String menuName);

	/**
	 * 分页查询权限数量
	 * @param currentPage 当前页
	 * @param pageSize 查询条数
	 * @param roleName 角色名称
	 * @param menuName 菜单名称
	 * @return
	 */
	Integer findPermissionPageCount(String currentPage, String pageSize,
			String roleName, String menuName);

	/**
	 * 保存权限
	 * @param permissionVo 权限vo
	 * @return
	 */
	PermissionVo savePermission(PermissionVo permissionVo);

	/**
	 * 
	 * @param permissionVo
	 */
	void deletePermission(PermissionVo permissionVo);

}
