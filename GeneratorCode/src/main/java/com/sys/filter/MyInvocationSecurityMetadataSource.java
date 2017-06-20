package com.sys.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.sys.service.role.RoleService;
import com.sys.vo.role.RoleVo;


public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	//将所有的角色和url的对应关系缓存起来  
	private static List<RoleVo> roles = null;
	
	/**
	 * 角色业务类
	 */
	@Autowired
	private RoleService roleService;
	
	
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;  
	
    //tomcat启动时实例化一次  
    public MyInvocationSecurityMetadataSource() {}     
 
    //参数是要访问的url，返回这个url对于的所有权限（或角色）  
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {   
        // 将参数转为url      
        String url = ((FilterInvocation)object).getRequestUrl();
        
        //根据路径查询这个用户的所有角色
        if(StringUtils.isNoneBlank(url)){
        	 roles = this.roleService.findRoleListByUrl(url); 
        }
        
      //匹配所有的url，并对角色去重 
        Set<String> roleSet = new HashSet<String>();  
        for(RoleVo ru : roles){
            roleSet.add(ru.getRoleCode());
        }
        
        Collection<ConfigAttribute> cas = new ArrayList<ConfigAttribute>();   
        for(String role : roleSet){
            ConfigAttribute ca = new SecurityConfig(role);  
            cas.add(ca);
        }
        return cas;
            
        } 
    
    
    public boolean supports(Class<?>clazz) {
            return true;    
            }
    
    public Collection<ConfigAttribute> getAllConfigAttributes() {
    	
        return null;    
        }

}
