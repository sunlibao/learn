package com.sys.service.user;

import java.util.List;

import com.sys.dto.user.UserDTO;
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
	List<UserDTO> findUserList(Integer page, Integer pageSize);

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

	/**
	 * 修改用户
	 * @param userVo 用户对象
	 */
	void updateUser(UserVo userVo);

	/**
	 * 删除用户
	 * @param userVo 用户对象
	 */
	void deleteUser(UserVo userVo);

	/**
	 * 设置用户角色id
	 * @param userId 用户id
	 * @param roleId 角色id
	 */
	void setUserRole(Long userId, Long roleId);
	

}
