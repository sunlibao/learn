package com.front.service;

import java.util.List;

import com.front.vo.Customer;

public interface MyFrontService {

	/**
	 * 根据用户名查询用户信息
	 * @param userName 客户用户名
	 * @return
	 */
	List<Customer> findCustomerByUserName(String userName);

	
}
