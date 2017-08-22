package com.sys.service.role;

import java.util.List;

import com.sys.entity.RoleEntity;
import com.sys.vo.role.RoleVo;

public interface RoleService{

	/**
	 * 根据路径查询这个用户的所有角色
	 * @param url 请求路径
	 * @return
	 */
	List<RoleVo> findRoleListByUrl(String url);

	/**
	 * 根据用户名查询角色
	 * @param username 用户名
	 * @return
	 */
	List<RoleVo> findRoleListByUserName(String username);

	/**
	 * 查询角色列表
	 * @return
	 */
	List<RoleEntity> findRoleList();

	/**
	 * 保存角色对象
	 * @param roleVo 角色vo
	 * @return
	 */
	RoleVo saveRole(RoleVo roleVo);

	/**
	 * 
	 * @param roleVo
	 */
	void deleteRole(RoleVo roleVo);

	
	

}
