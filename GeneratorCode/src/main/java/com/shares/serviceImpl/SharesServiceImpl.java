package com.shares.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shares.dao.SharesDao;
import com.shares.dto.SharesDTO;
import com.shares.service.SharesService;
import com.shares.vo.SharesVO;
import com.shares.vo.UserSharesRecordVO;

@Service
public class SharesServiceImpl implements SharesService {

	/**
	 * 股票daoimp
	 */
	@Autowired
	private SharesDao sharesDao;
	
	@Override
	public List<SharesDTO> findMyShares(Long id) {
		
		List<SharesDTO> result = this.sharesDao.findMyShares(id);
		
		return result;
	}

	@Override
	public List<UserSharesRecordVO> findShareOptionByUserSharesId(
			String userSharesId) {
		
		List<UserSharesRecordVO> result = this.sharesDao.findShareOptionByUserSharesId(userSharesId);
		
		
		return result;
	}

	@Override
	public SharesVO findShareById(String shareId) {
		
		SharesVO sharesVO = this.sharesDao.findShareById(shareId);
		
		return sharesVO;
	}

	@Override
	public Integer saveUserOptionRecord(String userSharesId, String price,
			String dealOption, String dealOptionTime, String note) {
		
		Integer result = this.sharesDao.saveUserOptionRecord( userSharesId,  price,
				 dealOption,  dealOptionTime,  note);
		
		return result;
	}

	@Override
	public Integer saveUserShares(Long userId, String sharesCode) {
		
		//根据股票编号查询股票
		//SharesVO sharesVO =  this.sharesDao.findSharesByCode(sharesCode);
		
		//如果股票不存在，则添加股票
		/*if(sharesVO == null ){
			Integer result = this.sharesDao.saveShares(sharesCode);
		}*/
		
		//
		Integer result = this.sharesDao.saveUserShares(userId,sharesCode,1);
		
		
		return result;
	}

	@Override
	public List<SharesVO> findSharesList() {
		
		List<SharesVO> result = this.sharesDao.findSharesList();
		
		return result;
	}

	@Override
	public Integer saveShares(String code, String name, String note) {
		
		Integer result = this.sharesDao.saveShares(code,name,note);
		
		return result;
	}

	@Override
	public Integer deleteShares(String sharesId) {
		
		Integer result = this.sharesDao.deleteShares(sharesId);
		
		return result;
	}

	@Override
	public Integer deleteUserSharesOptionById(String id) {
		
		Integer result = this.sharesDao.deleteUserSharesOptionById(id);
		
		return result;
	}

	@Override
	public Integer deleteUserShares(String id) {
		
		Integer result = this.sharesDao.deleteUserShares(id);
		
		return result;
	}
	

	

}
