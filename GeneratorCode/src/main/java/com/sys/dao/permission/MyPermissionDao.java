package com.sys.dao.permission;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sys.dao.base.BaseRepository;
import com.sys.dto.permission.PermissionDTO;
import com.sys.entity.permission.PermissionEntity;
import com.sys.vo.pemission.PermissionVo;

/**
 * 权限数据处理类
 * @author sunlibao
 *
 */
public interface MyPermissionDao extends BaseRepository<PermissionEntity>{

	
	/**
	 * 根据角色id和资源id查询权限
	 * @param roleId 角色id
	 * @param resId 资源id
	 * @return
	 */
	@Query("from PermissionEntity where roleId = ?1 and resId = ?2 ")
	PermissionVo findByRoleIdAndResId(Long roleId, Long resId);
	
	
}
