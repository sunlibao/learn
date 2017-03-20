package com.sys.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.service.user.UserService;
import com.sys.web.controller.util.ApiDemand;
import com.sys.web.controller.util.BillModel;
import com.sys.web.controller.util.Demand.ReturnCode;
import com.sys.web.controller.util.ParamUtil;

@Controller
public class UserController {
    
	@Autowired
	private UserService userService;
	
	
    @RequestMapping("/user/login")
    @ResponseBody
    public ApiDemand login(@RequestParam String param) {
    	
    	ApiDemand apiDemand = new ApiDemand();
    	
    	BillModel billModel = ParamUtil.parseBillModel(param);
    	
    	if(StringUtils.isBlank(billModel.getString("userName"))){
    		
    		apiDemand.setCode(ReturnCode.);
    		
    	}
    	
    	
    	
    	
    	
    	
    	Map<String,Object> resMap = new HashMap<String, Object>();
    	
    	
    	resMap.put("fanren", "hello");
    	
    	apiDemand.setData(resMap);
    	
        return apiDemand;
        
    }
    
    
    

}
