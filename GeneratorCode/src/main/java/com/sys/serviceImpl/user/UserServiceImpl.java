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


	@Override
	public List<UserVo> findUserList(Integer page, Integer pageSize) {
		
		String sqlstr = "select * from basic_user  limit "+(page-1)*pageSize+","+pageSize+" ";
		
		List<UserVo> result = this.jdbcTemplate.query(sqlstr,
				new Object[]{} ,new BeanPropertyRowMapper<UserVo>(UserVo.class));
		
		return result;
	}


	@Override
	public Integer findUserCount() {
		
		String sqlstr = "select count(*)  from basic_user ";
		
		Integer result = this.jdbcTemplate.queryForObject(sqlstr, Integer.class);
		
		return result;
		
	}


	@Override
	public void saveUser(UserVo userVo) {
		
		String sqlstr = "insert into basic_user(username,password) values(?,?) ";
		
		this.jdbcTemplate.update(sqlstr, new Object[]{userVo.getUsername(),userVo.getPassword()});
		
	}
	
	
	
	
}
