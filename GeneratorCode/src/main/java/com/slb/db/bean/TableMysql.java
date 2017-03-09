package com.slb.db.bean;

/**
 * mysql数据库结构对象
 * @author sunlibao
 *
 */
public class TableMysql {
	
	/**
	 * 表名称
	 */
	private String tableName;
	
	/**
	 * 表注释
	 */
	private String tableComment;
	
	
	
	public TableMysql() {
		super();
	}

	public TableMysql(String tableName, String tableComment) {
		super();
		this.tableName = tableName;
		this.tableComment = tableComment;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	
	
	

}
