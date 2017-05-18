package com.shares.vo;

import java.math.BigDecimal;

/**
 * 用户股票操作记录表
 * @author sunlibao
 *
 */
public class UserSharesRecordVO {
	
	/**
	 * 主键id
	 */
	private Long id;
	
	/**
	 * 用户股票id
	 */
	private Long userSharesId;
	
	/**
	 * 价格
	 */
	private BigDecimal price ;
	
	/**
	 * 操作
	 */
	private int dealOption;
	
	/**
	 * 操作说明
	 */
	private int note;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserSharesId() {
		return userSharesId;
	}

	public void setUserSharesId(Long userSharesId) {
		this.userSharesId = userSharesId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getDealOption() {
		return dealOption;
	}

	public void setDealOption(int dealOption) {
		this.dealOption = dealOption;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	
	
	
	

}
