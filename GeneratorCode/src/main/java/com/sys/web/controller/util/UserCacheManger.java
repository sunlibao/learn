package com.sys.web.controller.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.sys.vo.user.UserVo;

/**
 * 用户缓存
 * @author sunlibao
 *
 */
public class UserCacheManger {
	
	private static Map<String,UserVo> cacheMap = new HashMap();
	
	/**
	 * 添加缓存
	 * @param userVo
	 * @return
	 */
	public static String pushUserCache(UserVo userVo){
		
		String key = UUID.randomUUID().toString();
		
		cacheMap.put(key, userVo);
		
		return key;
	}
	
	/**
	 * 查询缓存中的数据
	 * @param key 
	 * @return
	 */
	public static UserVo getUserCache(String key){
		
		UserVo userVo = cacheMap.get(key);
		
		return userVo;
	}
	
	/**
	 * 删除缓存
	 * @param key
	 */
	public static void removeUserCashe(String key){

		cacheMap.remove(key);
		
	}
	

}
