package com.front.dao;

import java.util.List;

import com.front.vo.Customer;

public interface FrontDao {

	
	List<Customer> findCustomerByUserName(String userName);

}
