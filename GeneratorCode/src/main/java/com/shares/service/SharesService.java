package com.shares.service;

import java.util.List;

import com.shares.dto.SharesDTO;

/**
 * 股票相关接口
 * @author sunlibao
 *
 */
public interface SharesService {

	/**
	 * 根据用户id查询我的股票
	 * @param id
	 * @return
	 */
	List<SharesDTO> findMyShares(Long id);
	
	

}
