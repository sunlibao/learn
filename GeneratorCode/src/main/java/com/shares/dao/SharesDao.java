package com.shares.dao;

import java.util.List;

import com.shares.dto.SharesDTO;
import com.shares.vo.SharesVO;
import com.shares.vo.UserSharesRecordVO;

public interface SharesDao {

	/**
	 * 分享
	 * @param id 用户id
	 * @return
	 */
	List<SharesDTO> findMyShares(Long userId);

	/**
	 * 根据用户股票id查询用户股票操作记录
	 * @param userSharesId 用户股票id
	 * @return
	 */
	List<UserSharesRecordVO> findShareOptionByUserSharesId(String userSharesId);

	/**
	 * 根据股票id查询股票基本信息
	 * @param shareId 股票id
	 * @return 股票对象
	 */
	SharesVO findShareById(String shareId);

	/**
	 * 保存用户股票记录
	 * @param userSharesId   用户股票id
	 * @param price 价格
	 * @param dealOption 操作 1-买入 2-卖出
	 * @param dealOptionTime 操作时间
	 * @param note 说明
	 * @return
	 */
	Integer saveUserOptionRecord(String userSharesId, String price,
			String dealOption, String dealOptionTime, String note);

}
