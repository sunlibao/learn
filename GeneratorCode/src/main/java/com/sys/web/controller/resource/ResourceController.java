package com.sys.web.controller.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.service.resource.ResourceService;
import com.sys.vo.resource.ResourceVo;

/**
 * 资源管理类
 * @author sunlibao
 *
 */
@Controller
public class ResourceController {
	
	/**
	 * 资源服务页面类
	 */
	@Autowired
	private ResourceService resourceService;
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/resource/findMeanList")
	@ResponseBody
	List<ResourceVo> findMenuList(){
		
		
		List<ResourceVo> result =  resourceService.findResourceByType("MENU");
		
		
		return result;
	}
	

}
