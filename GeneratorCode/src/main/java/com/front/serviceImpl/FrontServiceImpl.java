package com.front.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.front.dao.FrontDao;
import com.front.service.MyFrontService;
import com.front.vo.Customer;


@Service
public class FrontServiceImpl implements MyFrontService {

	@Autowired
	private FrontDao frontDao;

	@Override
	public List<Customer> findCustomerByUserName(String userName) {
		
		List<Customer> result = frontDao.findCustomerByUserName(userName);
		
		return result;
	}
	
	
	
	
}
