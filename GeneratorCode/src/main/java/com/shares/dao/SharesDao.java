package com.shares.dao;

import java.util.List;

import com.shares.dto.SharesDTO;

public interface SharesDao {

	/**
	 * 分享
	 * @param id 用户id
	 * @return
	 */
	List<SharesDTO> findMyShares(Long userId);

}
