package com.slb.beanGenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slb.db.manager.DBUtil;
import com.slb.utill.ColumnDataUtil;


public class BeanGenereator {
	
	
	/**
	 * 根据数据库的名称查询所有的表名
	 * @param dbName 数据库名称
	 * @return 数据库中表名列表
	 */
	public List<String> findTableName(String databaseName){
		
		List<String> tableNameList = null;
		
		//查询数据库中的所有的表名
    	
    	try {
    		
			Connection conn = DBUtil.getConnection();
			
			//查询所有的数据库表名
			String sqlstr = "select table_name from information_schema.tables where table_schema= ?  and table_type='base table'";
			
			PreparedStatement preparedStatement  = conn.prepareStatement(sqlstr);
			
			preparedStatement.setString(1, databaseName);

			ResultSet rs =  preparedStatement.executeQuery();
			
			tableNameList = new ArrayList<String>();
			
			while(rs.next()){
				String name =  rs.getString("table_name");
				tableNameList.add(name);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tableNameList;
		
	}
	
	
	/**
	 * 返回表的列表
	 * @param tableName 数据库名称
	 * @return  返回表中的所有列
	 */
	public List<ColumnMysql> findColumnName(String tableName,String database){
		
		List<ColumnMysql> propertyList = null;
		
		//查询数据库中的所有的表名
    	
    	try {
    		
			Connection conn = DBUtil.getConnection();
			
			//查询所有的数据库表名
			String sqlstr = "SELECT "
					+ " column_name,DATA_TYPE "
					+ " FROM "
					+ " information_schema. COLUMNS "
					+ " WHERE table_name = ? and TABLE_SCHEMA = ? ";
			
			PreparedStatement preparedStatement  = conn.prepareStatement(sqlstr);
			//设置表名
			preparedStatement.setString(1, tableName);
			//设置库名
			preparedStatement.setString(2, database);

			ResultSet rs =  preparedStatement.executeQuery();
			
			propertyList = new ArrayList<>();
			
			ColumnMysql columnMysql = null;
			while(rs.next()){
				
				String columnName =  rs.getString("column_name");
				String columnType =  rs.getString("DATA_TYPE");
				
				ColumnMysql columnNode= new ColumnMysql(columnName,ColumnDataUtil.parseColumnToJava(columnType));
				
				
				propertyList.add(columnNode);
				
			}
				
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return propertyList;
		
	}
	
	
	

}
