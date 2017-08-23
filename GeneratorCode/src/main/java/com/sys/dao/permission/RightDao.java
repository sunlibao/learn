package com.sys.dao.permission;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sys.dto.permission.PermissionDTO;
import com.sys.vo.pemission.PermissionVo;

public interface RightDao {

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
	 * 分页查询权限的数量
	 * @param currentPage 当前页
	 * @param pageSize 查询条数
	 * @param roleName 角色名称
	 * @param menuName 菜单名称
	 * @return
	 */
	Integer findPermissionPageCount(String currentPage, String pageSize,
			String roleName, String menuName);
	
	
	
}
