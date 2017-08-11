package com.sys.service.user;

import java.util.List;

import com.sys.vo.user.UserVo;





/**
 * 用户相关接口
 * @author sunlibao
 *
 */
public interface UserService {
	
	List<UserVo> findUserList();

	/**
	 * 根据用户名查询用户信息
	 * @param userName 用户姓名
	 * @return 用户对象
	 */
	UserVo findUserByUserName(String userName);

	/**
	 * 分页查询用户
	 * @param page 当前页
	 * @param pageSize 查询条数
	 * @return
	 */
	List<UserVo> findUserList(Integer page, Integer pageSize);

	/**
	 * 查询用户总数量
	 * @return
	 */
	Integer findUserCount();

	/**
	 * 保存用户
	 * @param userVo
	 */
	void saveUser(UserVo userVo);
	

}
