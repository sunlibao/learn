package com.sys.web.controller.role;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.RoleEntity;
import com.sys.service.role.RoleService;

/**
 * 角色管理
 * @author sunlibao
 *
 */
@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("role/findRoleList.do")
	@ResponseBody
	List<RoleEntity> findRoleList(HttpServletRequest request){
		
		List<RoleEntity> result =  this.roleService.findRoleList();
		
		return result;
	}
	
	

}
