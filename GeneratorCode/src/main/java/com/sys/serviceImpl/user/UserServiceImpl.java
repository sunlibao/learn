package com.sys.serviceImpl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sys.service.user.UserService;

import foo.User;


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
	public List<User> findUserList() {
		
		List<User> result = this.jdbcTemplate.query("select * from basic_user ", new BeanPropertyRowMapper<User>(User.class));
		
		return result;
	}
	
	
	
	
}
