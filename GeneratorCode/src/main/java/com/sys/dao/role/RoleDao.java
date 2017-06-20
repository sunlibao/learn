package com.sys.dao.role;

import java.util.List;

import com.sys.vo.role.RoleVo;

public interface RoleDao {

	/**
	 * 根据地址查询角色信息
	 * @param url 请求地址
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
