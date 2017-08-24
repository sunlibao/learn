package com.sys.serviceImpl.user;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dao.user.UserDao;
import com.sys.dto.user.UserDTO;
import com.sys.entity.user.UserEntity;
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
	
	@Autowired
	private UserDao userDao;
	

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
	public List<UserDTO> findUserList(Integer page, Integer pageSize) {
		
		String sqlstr = "select u.id ,u.userName ,u.`password`,r.roleName,ur.roleId from basic_user u"
				+ " LEFT JOIN basic_user_role ur on u.id = ur.userId"
				+ " left join basic_role r on ur.roleId = r.id  ";
		
		sqlstr +=  "limit "+(page-1)*pageSize+","+pageSize+" ";
		
		List<UserDTO> result = this.jdbcTemplate.query(sqlstr,
				new Object[]{} ,new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
		return result;
	}


	@Override
	public Integer findUserCount() {
		
		String sqlstr = "select count(*)  from basic_user ";
		
		Integer result = this.jdbcTemplate.queryForObject(sqlstr, Integer.class);
		
		return result;
		
	}


	@Override
	@Transactional
	public void saveUser(UserVo userVo) {
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(userVo, userEntity);
		
		this.userDao.save(userEntity);
		
	}

	@Override
	public void updateUser(UserVo userVo) {
		
		String sqlstr = "update  basic_user set username = ? ,password = ?  where id = ?  ";
		
		this.jdbcTemplate.update(sqlstr, new Object[]{userVo.getUsername(),userVo.getPassword(),userVo.getId()});
		
	}


	@Override
	public void deleteUser(UserVo userVo) {
		
		String sqlstr = "delete  from  basic_user  where id = ?  ";
		
		this.jdbcTemplate.update(sqlstr, new Object[]{userVo.getId()});
		
	}


	@Override
	@Transactional
	public void setUserRole(Long userId, Long roleId) {
		
		Integer o = this.jdbcTemplate.queryForObject("select count(*) from basic_user_role where userId = ? ",Integer.class ,new Object[]{userId});
		
		if(o == 0){//没有添加
			this.jdbcTemplate.update("insert into  basic_user_role(roleId,userId) values(?,?)", new Object[]{roleId,userId});
		}else{//含有就修改
			this.jdbcTemplate.update("update basic_user_role set roleId = ? where userId = ?", new Object[]{roleId,userId});
		}
		
	}
	
	
	
	
}
