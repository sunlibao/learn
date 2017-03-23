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
	

}
