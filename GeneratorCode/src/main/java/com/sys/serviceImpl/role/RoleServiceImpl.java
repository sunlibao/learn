package com.sys.serviceImpl.role;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dao.role.RoleDao;
import com.sys.entity.RoleEntity;
import com.sys.service.role.RoleService;
import com.sys.vo.role.RoleVo;

@Service
public class RoleServiceImpl  implements RoleService  {


	/**
	 * 角色数据类
	 */
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<RoleVo> findRoleListByUrl(String url) {
		
		return roleDao.findRoleListByUrl(url);
		
	}

	@Override
	public List<RoleVo> findRoleListByUserName(String username) {
		
		return roleDao.findRoleListByUserName(username);
	}

	
	@Override
	public List<RoleEntity> findRoleList() {
		
		return this.roleDao.findAll();
		
	}

	@Override
	@Transactional
	public RoleVo saveRole(RoleVo roleVo) {
		
		RoleEntity roleEntity = new RoleEntity();
		
		BeanUtils.copyProperties(roleVo, roleEntity);
		
		this.roleDao.save(roleEntity);
		
		roleVo.setId(roleEntity.getId());
		
		return roleVo;
	}

	@Override
	@Transactional
	public void deleteRole(RoleVo roleVo) {
		
		this.roleDao.delete(roleVo.getId());
		
	}

	
	

}
