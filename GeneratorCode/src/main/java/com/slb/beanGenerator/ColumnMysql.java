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
	
	
	public ColumnMysql() {
		
	}
	

	public ColumnMysql(String columnName, String columnType) {
		super();
		this.columnName = columnName;
		this.columnType = columnType;
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
	
	
	
	
	
	
	
	

}
