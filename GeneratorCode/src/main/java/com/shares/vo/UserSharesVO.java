package com.shares.vo;

/**
 * 用户股票（用户股票关系表）
 * @author sunlibao
 *
 */
public class UserSharesVO {
	
	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 股票编号
	 */
	private String sharesCode;
	
	/**
	 * 状态   1-关注  2-持仓  3-清仓
	 */
	private Integer state;
	
	/**
	 * 是否删除  0-正常 1-删除
	 */
	private Integer dr;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getDr() {
		return dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

	public String getSharesCode() {
		return sharesCode;
	}

	public void setSharesCode(String sharesCode) {
		this.sharesCode = sharesCode;
	}
	
	
	

}
