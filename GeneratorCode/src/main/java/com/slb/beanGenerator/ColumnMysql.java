package com.slb.beanGenerator;

public class ColumnMysql {
	
	/**
	 * 列名
	 */
	private String columnName;
	
	/**
	 * 列类型
	 */
	private String columnType;
	
	
	/**
	 * 字段说明
	 */
	private String columnComment;
	
	
	public ColumnMysql() {
		
	}
	

	public ColumnMysql(String columnName, String columnType,
			String columnComment) {
		super();
		this.columnName = columnName;
		this.columnType = columnType;
		this.columnComment = columnComment;
	}


	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}


	public String getColumnComment() {
		return columnComment;
	}


	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	
	
	
	
	
	
	
	

}
