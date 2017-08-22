package com.sys.web.controller.role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sys.entity.RoleEntity;
import com.sys.service.role.RoleService;
import com.sys.vo.resource.ResourceVo;
import com.sys.vo.role.RoleVo;
import com.sys.web.controller.util.ApiDemand;
import com.sys.web.controller.util.ReturnCode;

/**
 * 角色管理
 * @author sunlibao
 *
 */
@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/system/role/roleList")
	@ResponseBody
	ApiDemand findRoleList(HttpServletRequest request){
		
		ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			String param = request.getParameter("param");
			
			RoleVo roleVo = JSONObject.parseObject(param, RoleVo.class);
			
			List<RoleEntity> result =  this.roleService.findRoleList();
			
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
	
	
	@RequestMapping("/system/role/saveRole")
	@ResponseBody
	ApiDemand saveRole(HttpServletRequest request){
		
		ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			String param = request.getParameter("param");
			
			RoleVo roleVo = JSONObject.parseObject(param, RoleVo.class);
			
			roleVo =  this.roleService.saveRole(roleVo);
			
			apiDemand.setData(roleVo);
    		apiDemand.setMsg(ReturnCode.SUCCESS.getName());
    		apiDemand.setCode(ReturnCode.SUCCESS.getCode());
        	
    		
    	}catch(Exception e){
    		apiDemand.setCode(ReturnCode.ERROR.getCode());
    		apiDemand.setMsg(ReturnCode.ERROR.getName());
    		e.printStackTrace();
    	}
    	
		 return apiDemand;
		
	}
	
	
	@RequestMapping("/system/role/deleteRole")
	@ResponseBody
	ApiDemand deleteRole(HttpServletRequest request){
		
		ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			String param = request.getParameter("param");
			
			RoleVo roleVo = JSONObject.parseObject(param, RoleVo.class);
			
			this.roleService.deleteRole(roleVo);
			
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
