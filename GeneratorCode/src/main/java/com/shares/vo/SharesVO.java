package com.shares.vo;

/**
 * 股票基础类
 * @author sunlibao
 *
 */
public class SharesVO {
	
	/**
	 * 主键id
	 */
	private Long id;
	
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
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	
	

}
