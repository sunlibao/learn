package com.sys.daoImpl.role;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sys.dao.role.RoleDao;
import com.sys.daoImpl.base.BaseRepositoryImpl;
import com.sys.vo.role.RoleVo;


public class RoleDaoImpl   {


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public List<RoleVo> findRoleListByUrl(String url) {
		
		String sqlstr = "SELECT role.* "
				+ " from basic_resource res "
				+ " join basic_permission per on res.id = per.resId "
				+ " join basic_role role on res.id "
				+ " where res.url = ? ";
		
		List<RoleVo> list = this.jdbcTemplate.query(sqlstr, new BeanPropertyRowMapper<RoleVo>(RoleVo.class),new Object[]{url});
		
		return list;
	}

	
	public List<RoleVo> findRoleListByUserName(String username) {
		
		String sqlstr = "SELECT role.* "
				+ " from basic_user u "
				+ " join basic_user_role ur on u.id = ur.userId "
				+ " join basic_role role  on role.id = ur.roleId "
				+ " where u.userName = ? ";
		
		List<RoleVo> list = this.jdbcTemplate.query(sqlstr, new BeanPropertyRowMapper<RoleVo>(RoleVo.class),new Object[]{username});
		
		return list;
		
	}
	
	
	
}
