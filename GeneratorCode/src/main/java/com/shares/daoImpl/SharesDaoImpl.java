package com.shares.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shares.dao.SharesDao;
import com.shares.dto.SharesDTO;
import com.shares.vo.SharesVO;
import com.shares.vo.UserSharesRecordVO;

@Repository
public class SharesDaoImpl implements SharesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<SharesDTO> findMyShares(Long userId) {
		
		String sqlstr ="SELECT  t2.id as 'shareId',t1.id as 'userSharesId',t1.`sharesCode` as 'code',t2.`name`,t2.note "
				+ " from userShares t1 "
				+ " left join t_shares t2 on t1.sharesCode = t2.code "
				+ "";
		
		List<SharesDTO> result = this.jdbcTemplate.query(sqlstr, new BeanPropertyRowMapper<SharesDTO>(SharesDTO.class));
		
		return result;
	}

	@Override
	public List<UserSharesRecordVO> findShareOptionByUserSharesId(
			String userSharesId) {
		
		String sqlstr ="SELECT  id,price,dealOption,note,dealOptionTime  from usersharesrecord where userSharesId = ?";
		
		List<UserSharesRecordVO> result = this.jdbcTemplate.query(sqlstr, new BeanPropertyRowMapper<UserSharesRecordVO>(UserSharesRecordVO.class),new Object[]{userSharesId});
		
		return result;
	}

	@Override
	public SharesVO findShareById(String shareId) {
		
		List<SharesVO> sharesList = this.jdbcTemplate.query("select id ,name ,code ,note from t_shares where id = ? ", new BeanPropertyRowMapper<SharesVO>(SharesVO.class),new Object[]{shareId});
		
		if(sharesList.size() > 0){
			return sharesList.get(0);
		}
			return null;
	}

	@Override
	public Integer saveUserOptionRecord(String userSharesId, String price,
			String dealOption, String dealOptionTime, String note) {
		
		String sqlstr = "INSERT into userSharesRecord (userSharesId,price,dealOption,dealOptionTime,note) values(?,?,?,?,?);";
		
		this.jdbcTemplate.update(sqlstr, new Object[]{userSharesId,price,dealOption,dealOptionTime,note});
		
		return 1;
	}

	
	@Override
	public Integer saveUserShares(Long userId, String sharesCode, int state) {
		
		String sqlstr = "INSERT into userShares (userId,sharesCode,state,dr) values(?,?,?,?);";
		
		this.jdbcTemplate.update(sqlstr, new Object[]{userId,sharesCode,state,0});
		
		return 1;
		
	}

	@Override
	public List<SharesVO> findSharesList() {
		
		String sqlstr = "select * from t_shares";
		
		List<SharesVO> result =  this.jdbcTemplate.query(sqlstr, new BeanPropertyRowMapper<SharesVO>(SharesVO.class));
		
		return result;
	}

	@Override
	public Integer saveShares(String code, String name, String note) {
		
		String sqlstr = "INSERT into t_shares (code,name,note) values(?,?,?);";
		
		this.jdbcTemplate.update(sqlstr, new Object[]{code,name,note});
		
		return 1;
		
	}

	@Override
	public Integer deleteShares(String sharesId) {
		
		String sqlstr = "delete from  t_shares where id = ?";
		
		this.jdbcTemplate.update(sqlstr, new Object[]{sharesId});
		
		return 1;
	}

	@Override
	public Integer deleteUserSharesOptionById(String id) {
		
		String sqlstr = "delete from  userSharesRecord where id = ?";
		
		this.jdbcTemplate.update(sqlstr, new Object[]{id});
		
		return 1;
		
	}

	@Override
	public Integer deleteUserShares(String id) {
		
		String sqlstr = "delete from  userShares  where id = ?";
		
		this.jdbcTemplate.update(sqlstr, new Object[]{id});
		
		return 1;
	}
	
	

}
