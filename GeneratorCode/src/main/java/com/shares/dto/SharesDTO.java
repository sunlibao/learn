package com.shares.dto;

import com.shares.vo.SharesVO;

public class SharesDTO extends SharesVO {
	
	/**
	 * 用户服务id
	 */
	private Long userSharesId;
	
	/**
	 * 股票id
	 */
	private Long shareId;
	
	/**
	 * 股票名称
	 */
	private String name ;
	
	/**
	 * 股票编号
	 */
	private String code ;
	
	/**
	 * 股票简介
	 */
	private String note;

	public Long getUserSharesId() {
		return userSharesId;
	}

	public void setUserSharesId(Long userSharesId) {
		this.userSharesId = userSharesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getShareId() {
		return shareId;
	}

	public void setShareId(Long shareId) {
		this.shareId = shareId;
	}
	
	
	
	

}
