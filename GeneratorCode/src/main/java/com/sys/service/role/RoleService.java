package com.sys.service.role;

import java.util.List;

import com.sys.vo.role.RoleVo;

public interface RoleService {

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

	
	

}
