package com.sys.serviceImpl.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dao.resource.ResourceDao;
import com.sys.entity.resource.ResourceEntity;
import com.sys.service.resource.ResourceService;
import com.sys.vo.resource.ResourceVo;

/**
 * 资源业务实现类
 * @author sunlibao
 *
 */
@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 资源jpa类
	 */
	@Autowired
	private ResourceDao resourceDao;
	
	

	@Override
	public List<ResourceVo> findResourceByType(String type) {

		String sqlstr = "select * from basic_resource where dr = 0 and type = ? ";
		
		List<ResourceVo> result = this.jdbcTemplate.query(sqlstr, new 
				BeanPropertyRowMapper<ResourceVo>(ResourceVo.class),new Object[]{type});
		

		return result;
	}

	@Transactional
	@Override
	public ResourceVo saveResource(ResourceVo resourceVo) {
		
		ResourceEntity resourceEntity = new ResourceEntity();
		
		BeanUtils.copyProperties(resourceVo, resourceEntity);
		
		resourceEntity = this.resourceDao.saveAndFlush(resourceEntity);
		
		resourceVo.setId(resourceEntity.getId());
		
		return resourceVo;
	}

	@Override
	public void deleteResource(ResourceVo resourceVo) {
		
		this.resourceDao.delete(resourceVo.getId());
		
	}
	

}
