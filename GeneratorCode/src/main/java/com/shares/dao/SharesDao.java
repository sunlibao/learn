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

	/**
	 * 保存用户股票
	 * @param userId 用户id
	 * @param sharesCode 股票编号
	 * @param state 1-关注  2-持仓  3-清仓
	 * @return
	 */
	Integer saveUserShares(Long userId, String sharesCode, int state);

	/**
	 * 查询系统股票
	 * @return 系统股票列表
	 */
	List<SharesVO> findSharesList();

	/**
	 * 保存系统 股票
	 * @param code 股票编号
	 * @param name 股票名称
	 * @param note 股票简介
	 * @return 操作结果
	 */
	Integer saveShares(String code, String name, String note);

	/**
	 * 删除系统股票
	 * @param sharesId 系统股票id
	 * @return 操作结果
	 */
	Integer deleteShares(String sharesId);
	
	/**
	 * 删除用户股票操作id
	 * @param id
	 * @return
	 */
	Integer deleteUserSharesOptionById(String id);

	/**
	 * 删除用户股票
	 * @param id 用户股票id
	 * @return
	 */
	Integer deleteUserShares(String id);

}
