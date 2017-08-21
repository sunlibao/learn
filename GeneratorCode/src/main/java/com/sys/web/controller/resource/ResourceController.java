package com.sys.web.controller.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sys.service.resource.ResourceService;
import com.sys.vo.resource.ResourceVo;
import com.sys.vo.user.UserVo;
import com.sys.web.controller.util.ApiDemand;
import com.sys.web.controller.util.BillModel;
import com.sys.web.controller.util.Global;
import com.sys.web.controller.util.PageModel;
import com.sys.web.controller.util.ParamUtil;
import com.sys.web.controller.util.ReturnCode;

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
	 * 菜单列表
	 * @return
	 */
	@RequestMapping("/resource/findMeanList")
	@ResponseBody
	public ApiDemand findMenuList(){
		
		ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			List<ResourceVo> result =  resourceService.findResourceByType(Global.MENU_TYPE);
			
    		apiDemand.setData(result);
    		apiDemand.setMsg(ReturnCode.SUCCESS.getName());
    		apiDemand.setCode(ReturnCode.SUCCESS.getCode());
        	
    		
    	}catch(Exception e){
    		apiDemand.setCode(ReturnCode.ERROR.getCode());
    		apiDemand.setMsg(ReturnCode.ERROR.getName());
    		e.printStackTrace();
    	}
    	
		 return apiDemand;
		
	}
	
	
	/**
	 * 保存菜单
	 * @return
	 */
	@RequestMapping("/resource/saveMenu")
	@ResponseBody
	public ApiDemand saveMenu(HttpServletRequest request){
		
		ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			String param = request.getParameter("param");
			
			ResourceVo resourceVo = JSONObject.parseObject(param, ResourceVo.class);
			resourceVo.setType(Integer.parseInt(Global.MENU_TYPE));
			resourceVo.setpId(new Long(0));
			
			resourceVo = this.resourceService.saveResource(resourceVo);
			
    		apiDemand.setData(resourceVo);
    		apiDemand.setMsg(ReturnCode.SUCCESS.getName());
    		apiDemand.setCode(ReturnCode.SUCCESS.getCode());
        	
    		
    	}catch(Exception e){
    		apiDemand.setCode(ReturnCode.ERROR.getCode());
    		apiDemand.setMsg(ReturnCode.ERROR.getName());
    		e.printStackTrace();
    	}
    	
		 return apiDemand;
		
	}
	
	
	
	/**
	 * 删除菜单
	 * @return
	 */
	@RequestMapping("/resource/deleteMenu")
	@ResponseBody
	public ApiDemand delteMenu(HttpServletRequest request){
		
		ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			String param = request.getParameter("param");
			
			ResourceVo resourceVo = JSONObject.parseObject(param, ResourceVo.class);
			
			this.resourceService.deleteResource(resourceVo);
    		
    		apiDemand.setMsg(ReturnCode.SUCCESS.getName());
    		apiDemand.setCode(ReturnCode.SUCCESS.getCode());
        	
    		
    	}catch(Exception e){
    		apiDemand.setCode(ReturnCode.ERROR.getCode());
    		apiDemand.setMsg(ReturnCode.ERROR.getName());
    		e.printStackTrace();
    	}
    	
		 return apiDemand;
		
	}
	
	

}
