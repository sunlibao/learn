package com.sys.serviceImpl.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sys.service.resource.ResourceService;
import com.sys.vo.resource.ResourceVO;

/**
 * 资源业务实现类
 * @author sunlibao
 *
 */
@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ResourceVO> findResourceByType(String type) {

		String sqlstr = "select * from basic_resource where dr = 0 and type = ? ";
		
		List<ResourceVO> result = this.jdbcTemplate.query(sqlstr, new 
				BeanPropertyRowMapper<ResourceVO>(ResourceVO.class),new Object[]{type});
		

		return result;
	}
	

}
