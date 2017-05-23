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
	

	

}
