package com.sys.serviceImpl.permission;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sys.dao.permission.MyPermissionDao;
import com.sys.dto.permission.PermissionDTO;
import com.sys.entity.permission.PermissionEntity;
import com.sys.service.permission.PermissionService;
import com.sys.vo.pemission.PermissionVo;

@Service
public class PermissionServcieImpl implements PermissionService {

	@Autowired
	private MyPermissionDao myPermissionDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PermissionDTO> findPermissionPage(String currentPage,
			String pageSize, String roleName, String menuName) {
		
		
		String sqlstr ="SELECT p.id,role.roleName,res.`name` as 'menuName' from basic_permission p  "
				+ " left join basic_role role on p.roleId = role.id "
				+ " left join basic_resource res on p.resId = res.id where 1=1 ";
		
		if(StringUtils.isNotBlank(roleName)){
			sqlstr +=" and role.roleName like '"+roleName+"%' ";
		}
		if(StringUtils.isNotBlank(menuName)){
			sqlstr +=" and res.name like '"+menuName+"%' ";
		}
		
		
		sqlstr += "limit "+((Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize))+","+pageSize;

		List<PermissionDTO> result = this.jdbcTemplate.query(sqlstr, new BeanPropertyRowMapper<PermissionDTO>(PermissionDTO.class));
		
		return result;
		
	}

	@Override
	public Integer findPermissionPageCount(String currentPage, String pageSize,
			String roleName, String menuName) {
		
		String sqlstr ="SELECT count(*) from basic_permission p  "
				+ " left join basic_role role on p.roleId = role.id "
				+ " left join basic_resource res on p.resId = res.id where 1=1 ";
		
		if(StringUtils.isNotBlank(roleName)){
			sqlstr +=" and role.roleName like '"+roleName+"%' ";
		}
		if(StringUtils.isNotBlank(menuName)){
			sqlstr +=" and res.name like '"+menuName+"%' ";
		}

		Integer result = this.jdbcTemplate.queryForObject(sqlstr, Integer.class);
		
		return result;
		
	}

	@Override
	public PermissionVo savePermission(PermissionVo permissionVo) {
		
		PermissionVo temp = myPermissionDao.findByRoleIdAndResId(permissionVo.getRoleId(),permissionVo.getResId());
		
		if(temp == null){
			
			PermissionEntity permissionEntity = new PermissionEntity();
			BeanUtils.copyProperties(permissionVo, permissionEntity);
			
			myPermissionDao.save(permissionEntity);
			permissionVo.setId(permissionEntity.getId());
			
		}
		
		return permissionVo;
	
	}
	
	
	
	
	

}
