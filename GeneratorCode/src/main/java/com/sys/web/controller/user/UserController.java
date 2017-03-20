package com.sys.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String,Object> test() {
    	
    	Map<String,Object> resMap = new HashMap<String, Object>();
    	
    	resMap.put("data", "hello");
    	
        return resMap;
        
    }
    
    
    

}
