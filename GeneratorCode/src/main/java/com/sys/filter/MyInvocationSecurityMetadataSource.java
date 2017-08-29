package com.sys.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.sys.entity.RoleEntity;
import com.sys.entity.resource.ResourceEntity;
import com.sys.service.role.RoleService;
import com.sys.vo.role.RoleVo;


public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	//将所有的角色和url的对应关系缓存起来  
	private static List<RoleEntity> roles = null;
	
	/**
	 * 角色业务类
	 */
	@Autowired
	private RoleService roleService;
	
	/**
	 * 资源集合类
	 */
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;  
    
	
    //tomcat启动时实例化一次  
    public MyInvocationSecurityMetadataSource() {
    	
    }
    
    /**
     * 加载所有的资源
     */
    private void loadResourcesDefine(){
    	
    	 resourceMap = new LinkedHashMap<String, Collection<ConfigAttribute>>(); 
    	
    	 roles = this.roleService.findRoleList();
    	 
    	 for(RoleEntity roleEntity : roles){
    		 Set<ResourceEntity> resEntities = roleEntity.getResourceSet();
    		 Iterator<ResourceEntity> it =  resEntities.iterator();
    		 while(it.hasNext()){
    			 ResourceEntity resourceEntity =  it.next();
    			 //获得资源的请求路径
    			 String url = resourceEntity.getUrl();
    			 
    			 Collection<ConfigAttribute> res =  resourceMap.get(url);
    			 if(res == null){
    				 res = new  ArrayList<ConfigAttribute>();
    				 res.add(new SecurityConfig(roleEntity.getRoleCode()));//添加角色
    				 resourceMap.put(url, res);
    			 }else{
    				 res.add(new SecurityConfig(roleEntity.getRoleCode()));//添加角色
    				 resourceMap.put(url, res);
    			 }
    			 
    			
    			 
    		 }
    		 
    	 }
    	
    }
    
    
    
    //参数是要访问的url，返回这个url对于的所有权限（或角色）  
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {   
       
    	if(resourceMap == null){
    		
    	}
    	
    	loadResourcesDefine();
    	
    	// 将参数转为url      
        String url = ((FilterInvocation)object).getRequestUrl();
        
        Collection<ConfigAttribute> cas = new ArrayList<ConfigAttribute>();  
        
        //不区分大小写
        UrlMatcher urlMatcher = new AntUrlPathMatcher(true);
        
        //具有路径匹配，怎返回这个路径所需要的所有的角色code
        for(Map.Entry<String, Collection<ConfigAttribute>> entry :  resourceMap.entrySet() ){
        	String key = entry.getKey();
        	if(urlMatcher.pathMatchesUrl(key, url)){
        		cas =  entry.getValue();
        	}
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
