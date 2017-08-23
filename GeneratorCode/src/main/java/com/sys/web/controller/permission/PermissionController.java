package com.sys.web.controller.permission;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sys.dto.permission.PermissionDTO;
import com.sys.entity.RoleEntity;
import com.sys.service.permission.PermissionService;
import com.sys.vo.pemission.PermissionVo;
import com.sys.vo.role.RoleVo;
import com.sys.web.controller.util.ApiDemand;
import com.sys.web.controller.util.BillModel;
import com.sys.web.controller.util.PageModel;
import com.sys.web.controller.util.ParamUtil;
import com.sys.web.controller.util.ReturnCode;

/**
 * 权限管理
 * @author sunlibao
 *
 */
@Controller
public class PermissionController {
	
	/**
	 * 权限业务类
	 */
	@Autowired
	private PermissionService permissionService;
	
	
	/**
	 * 分页查询数据
	 * @param request 
	 * @return
	 */
	@RequestMapping("/system/permission/findPermissionPage")
	@ResponseBody
	ApiDemand findPermissionPage(HttpServletRequest request){
		
		ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			String param = request.getParameter("param");
			
			BillModel billModel = ParamUtil.parseBillModel(param);
			
			String currentPage = billModel.getString("currentPage");//当前页
			String pageSize = billModel.getString("pageSize");//查询条数
			String roleName = billModel.getString("roleName");//角色名称
			String menuName = billModel.getString("menuName");//菜单名称
			
			if(StringUtils.isBlank(currentPage)){
				apiDemand.setCode(ReturnCode.NOTNULL.getCode());
				apiDemand.setMsg("currentPage"+ReturnCode.NOTNULL.getName());
			}else if(StringUtils.isBlank(pageSize)){
				apiDemand.setCode(ReturnCode.NOTNULL.getCode());
				apiDemand.setMsg("pageSize"+ReturnCode.NOTNULL.getName());
			}else{
				
				List<PermissionDTO> result =  this.permissionService.findPermissionPage(currentPage,pageSize,roleName,menuName);
				
				Integer count = this.permissionService.findPermissionPageCount(currentPage,pageSize,roleName,menuName);
				
				PageModel pageModel = new PageModel();
				
				pageModel.setCurrentPage(Integer.parseInt(currentPage));
				pageModel.setData(result);
				pageModel.setTotalCount(count);
				
				apiDemand.setData(pageModel);
	    		apiDemand.setMsg(ReturnCode.SUCCESS.getName());
	    		apiDemand.setCode(ReturnCode.SUCCESS.getCode());
			}
    	}catch(Exception e){
    		apiDemand.setCode(ReturnCode.ERROR.getCode());
    		apiDemand.setMsg(ReturnCode.ERROR.getName());
    		e.printStackTrace();
    	}
    	
		 return apiDemand;
		
	}
	
	
	
	/**
	 * 保存权限
	 * @param request 
	 * @return
	 */
	@RequestMapping("/system/permission/savePermission")
	@ResponseBody
	ApiDemand savePermission(HttpServletRequest request){
		
		ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			String param = request.getParameter("param");
			
			//数据转换
			PermissionVo permissionVo = JSONObject.parseObject(param,PermissionVo.class);
			
			permissionVo = this.permissionService.savePermission(permissionVo);
			
			apiDemand.setData(permissionVo);
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
