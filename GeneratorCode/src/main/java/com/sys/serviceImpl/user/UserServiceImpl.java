package com.sys.serviceImpl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sys.service.user.UserService;
import com.sys.vo.user.UserVo;


/**
 * 用户实现类相关
 * @author sunlibao
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserVo> findUserList() {
		
		List<UserVo> result = this.jdbcTemplate.query(" select * from basic_user ", new BeanPropertyRowMapper<UserVo>(UserVo.class));
		
		return result;
	}
	

	@Override
	public UserVo findUserByUserName(String userName) {
		UserVo userVo = null;
		
		
		List<UserVo> result = this.jdbcTemplate.query("select * from basic_user where userName = ? ",
				new Object[]{userName} ,new BeanPropertyRowMapper<UserVo>(UserVo.class));
		
		if(result.size() > 0){
			userVo =  result.get(0);
		}
		
		return userVo;
	}
	
	
	
	
}
