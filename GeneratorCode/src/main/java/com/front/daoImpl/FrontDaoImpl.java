package com.front.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.front.dao.FrontDao;
import com.front.vo.Customer;

@Repository
public class FrontDaoImpl implements FrontDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> findCustomerByUserName(String userName) {
		
		String sqlstr = "select * from b_customer where userName = ?";
		
		List<Customer> result = this.jdbcTemplate.query(sqlstr, new BeanPropertyRowMapper<Customer>(Customer.class),new Object[]{userName});
		
		return result;
	}
	

}
