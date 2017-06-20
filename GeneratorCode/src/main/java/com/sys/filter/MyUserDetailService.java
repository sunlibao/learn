package com.sys.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sys.service.role.RoleService;
import com.sys.service.user.UserService;
import com.sys.vo.role.RoleVo;
import com.sys.vo.user.UserVo;

public class MyUserDetailService implements UserDetailsService {

	/**
	 * 角色业务类
	 */
	@Autowired
	private RoleService roleService;
	
	/**
	 * 用户业务处理
	 */
	@Autowired
	private UserService userService;
	
	//登陆验证时，通过username获取用户的所有权限信息，  
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用  
    public UserDetails loadUserByUsername(String username)   
            throws UsernameNotFoundException, DataAccessException { 
    	
        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();   
        
        List<RoleVo> roleList = this.roleService.findRoleListByUserName(username);
        
        for(RoleVo roleVo : roleList){
        	auths.add(new GrantedAuthorityImpl(roleVo.getRoleCode()));
        }
        
        //查询用户
        UserVo userVo = this.userService.findUserByUserName(username);
 
        User user = new User(userVo.getUsername(), userVo.getPassword(), true, true, true, true, auths);   
       
        return user;    
        } 
	
}
