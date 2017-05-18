package com.shares.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shares.dao.SharesDao;
import com.shares.dto.SharesDTO;
import com.shares.vo.SharesVO;

@Repository
public class SharesDaoImpl implements SharesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<SharesDTO> findMyShares(Long userId) {
		
		String sqlstr ="SELECT t1.id as 'userSharesId',t2.`code`,t2.`name`,t2.note "
				+ " from userShares t1 "
				+ " left join t_shares t2 on t1.sharesId = t2.id "
				+ "";
		
		List<SharesDTO> result = this.jdbcTemplate.query(sqlstr, new BeanPropertyRowMapper<SharesDTO>(SharesDTO.class));
		
		return result;
	}
	
	

}
