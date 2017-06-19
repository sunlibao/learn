package com.sys.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.service.user.UserService;
import com.sys.vo.user.UserVo;
import com.sys.web.controller.util.ApiDemand;
import com.sys.web.controller.util.BillModel;
import com.sys.web.controller.util.ParamUtil;
import com.sys.web.controller.util.ReturnCode;

@Controller
public class UserController {
    
	/**
	 * 用户业务处理类
	 */
	@Autowired
	private UserService userService;
	
	
    @RequestMapping("/user/login")
    @ResponseBody
    public ApiDemand login(HttpServletRequest request) {
    	
    	ApiDemand apiDemand = new ApiDemand();
    	
    	try{
    		String param = request.getParameter("param");
    		
    		BillModel billModel = ParamUtil.parseBillModel(param);
    		
    		if(StringUtils.isBlank(billModel.getString("userName"))){
        		apiDemand.setCode(ReturnCode.NOTNULL.getCode());
        		apiDemand.setMsg("userName "+ReturnCode.NOTNULL.getName());
        	}else if(StringUtils.isBlank(billModel.getString("password"))){
        		apiDemand.setCode(ReturnCode.NOTNULL.getCode());
        		apiDemand.setMsg("password"+ReturnCode.NOTNULL.getName());
        	}else{
        		
        		Map<String,Object> resMap = new HashMap<String, Object>();
        		
        		UserVo userVo = this.userService.findUserByUserName(billModel.getString("userName"));
        		
        		if(userVo == null){
        			apiDemand.setCode(ReturnCode.NOTEXIST.getCode());
            		apiDemand.setMsg("当前用户"+ReturnCode.NOTEXIST.getName());
        		}else{
        			
        			if(userVo.getPassword().equalsIgnoreCase(billModel.getString("password"))){
        				resMap.put("data", userVo);
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
    
    
    
    
    
    

}
