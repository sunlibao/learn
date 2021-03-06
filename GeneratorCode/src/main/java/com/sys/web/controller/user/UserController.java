package com.sys.web.controller.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sys.dto.LoginDto;
import com.sys.dto.user.UserDTO;
import com.sys.service.user.UserService;
import com.sys.vo.user.UserVo;
import com.sys.web.controller.util.ApiDemand;
import com.sys.web.controller.util.PageModel;
import com.sys.web.controller.util.BillModel;
import com.sys.web.controller.util.ParamUtil;
import com.sys.web.controller.util.ReturnCode;
import com.sys.web.controller.util.UserCacheManger;

@Controller
public class UserController {
    
	/**
	 * 用户业务处理类
	 */
	@Autowired
	private UserService userService;
	
	
    @RequestMapping("/user/login")
    @ResponseBody
    public ApiDemand login(HttpServletRequest request,HttpServletResponse response) {
    	
    	
    	ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
			String keycode = request.getParameter("key");
			System.out.println(keycode);
			
    		String param = request.getParameter("param");
    		
    		System.out.println(param);
    		
    		BillModel billModel = ParamUtil.parseBillModel(param);
    		 
    		
    		if(StringUtils.isBlank(billModel.getString("userName"))){
        		apiDemand.setCode(ReturnCode.NOTNULL.getCode());
        		apiDemand.setMsg("用户名"+ReturnCode.NOTNULL.getName());
        	}else if(StringUtils.isBlank(billModel.getString("password"))){
        		apiDemand.setCode(ReturnCode.NOTNULL.getCode());
        		apiDemand.setMsg("密码"+ReturnCode.NOTNULL.getName());
        	}else{
        		
        		Map<String,Object> resMap = new HashMap<String, Object>();
        		
        		UserVo userVo = this.userService.findUserByUserName(billModel.getString("userName"));
        		
        		if(userVo == null){
        			apiDemand.setCode(ReturnCode.NOTEXIST.getCode());
            		apiDemand.setMsg("当前用户"+ReturnCode.NOTEXIST.getName());
        		}else{
        			if(userVo.getPassword().equalsIgnoreCase(billModel.getString("password"))){
        				
        				String key = UserCacheManger.pushUserCache(userVo);
        				
        				//LoginDto loginDto = new LoginDto(key, userVo);
        				
        				//resMap.put("data", loginDto);
        				
                    	apiDemand.setData(resMap);
                    	apiDemand.setCode(ReturnCode.SUCCESS.getCode());
                		apiDemand.setMsg(ReturnCode.SUCCESS.getName());
        			}else{
        				apiDemand.setCode(ReturnCode.NOTRIGHT.getCode());
                		apiDemand.setMsg("密码"+ReturnCode.NOTRIGHT.getName());
        			}
        			
        		}
            	
        	}
    		
    	}catch(Exception e){
    		apiDemand.setCode(ReturnCode.ERROR.getCode());
    		apiDemand.setMsg(ReturnCode.ERROR.getName());
    		e.printStackTrace();
    	}
		
        return apiDemand;
    	}
    	
    
    /**
     * 查询用户列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/system/user/findUserPage")
    @ResponseBody
    public ApiDemand findUserPage(HttpServletRequest request,HttpServletResponse response){

    	ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
    		String param = request.getParameter("param");
    		
    		BillModel billModel = ParamUtil.parseBillModel(param);
    		
    		if(StringUtils.isBlank(billModel.getString("page"))){
        		apiDemand.setCode(ReturnCode.NOTNULL.getCode());
        		apiDemand.setMsg("page"+ReturnCode.NOTNULL.getName());
        	}else if(StringUtils.isBlank(billModel.getString("pageSize"))){
        		apiDemand.setCode(ReturnCode.NOTNULL.getCode());
        		apiDemand.setMsg("pageSize"+ReturnCode.NOTNULL.getName());
        	}else{
        		
        		Integer page = billModel.getInteger("page");
        		
        		Integer pageSize = billModel.getInteger("pageSize");
        		
        		List<UserDTO> userList = this.userService.findUserList(page,pageSize);
        		
        		Integer count = this.userService.findUserCount();
        		
        		PageModel pageModel = new PageModel();
        		
        		pageModel.setCurrentPage(page);
        		pageModel.setPageSize(pageSize);
        		pageModel.setTotalCount(count);
        		pageModel.setData(userList);
        		pageModel.setTotalPage(count%pageSize==0?count/pageSize:count/pageSize+1);
        		
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
     * 保存用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/system/user/saveUser")
    @ResponseBody
    public ApiDemand save(HttpServletRequest request,HttpServletResponse response){

    	
    	ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
    		String param = request.getParameter("param");
    		
    		UserVo userVo = JSONObject.parseObject(param, UserVo.class);
    		
    		if(userVo.getDr()==null){
    			userVo.setDr(0);
    		}
    		
    		this.userService.saveUser(userVo);
        		
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
     * 删除用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/system/user/deleteUser")
    @ResponseBody
    public ApiDemand deleteUser(HttpServletRequest request,HttpServletResponse response){

    	
    	ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
    		String param = request.getParameter("param");
    		
    		UserVo userVo = JSONObject.parseObject(param, UserVo.class);
        		
    		this.userService.deleteUser(userVo);
        		
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
     * 设置用户角色
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(" /system/user/setUserRole")
    @ResponseBody
    public ApiDemand setUserRole(HttpServletRequest request,HttpServletResponse response){

    	
    	ApiDemand apiDemand = new ApiDemand();
    	
		try{
			
    		String param = request.getParameter("param");
    		
    		BillModel billModel = ParamUtil.parseBillModel(param);
        		
    		Long userId = billModel.getLong("userId");
    		Long roleId = billModel.getLong("roleId");
    		
    		
    		this.userService.setUserRole(userId,roleId);
        		
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
     * 记载用户角色资源
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/system/user/loadUserMenu")
    @ResponseBody
    public ApiDemand loadUserMenu(HttpServletRequest request,HttpServletResponse response){

    	
    	ApiDemand apiDemand = new ApiDemand();
    	
    	
		try{
			
			Map<String,Object> resMap = new HashMap<String, Object>();
			
			 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
		                .getAttribute("SPRING_SECURITY_CONTEXT");
			 
			 List<GrantedAuthority> authorities = (List<GrantedAuthority>)securityContextImpl.getAuthentication().getAuthorities();   

			apiDemand.setData(authorities);
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
