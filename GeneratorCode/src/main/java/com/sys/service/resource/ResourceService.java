package com.sys.service.resource;

import java.util.List;

import com.sys.vo.resource.ResourceVo;

/**
 * 资源相关业务类
 * @author sunlibao
 *
 */
public interface ResourceService {

	/**
	 * 根据资源类型查询菜单
	 * @param type
	 * @return
	 */
	List<ResourceVo> findResourceByType(String type);

	/**
	 * 保存资源
	 * @param resourceVo
	 * @return
	 */
	ResourceVo saveResource(ResourceVo resourceVo);

	/**
	 * 删除资源
	 * @param resourceVo 资源vo
	 */
	void deleteResource(ResourceVo resourceVo);
	

}
