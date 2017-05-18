package com.shares.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shares.dao.SharesDao;
import com.shares.dto.SharesDTO;
import com.shares.service.SharesService;

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
	

	

}
