package com.slb.beanGenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.slb.db.manager.DBUtil;
import com.slb.utill.ColumnDataUtil;
import com.slb.write.WriteFile;


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
					+ " column_name as 'columnName',DATA_TYPE as 'columnType' ,column_comment as 'columnComment' "
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
				
				String columnName =  rs.getString("columnName");
				String columnType =  rs.getString("columnType");
				String columnComment=  rs.getString("columnComment");
				
				ColumnMysql columnNode= new ColumnMysql(columnName,ColumnDataUtil.parseColumnToJava(columnType),columnComment);
				
				
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
	
	
	/**
	 * 
	 * @param dir 路径地址
	 * @param databaseName 数据库名称
	 * @return
	 */
	public String writeBeanByDataBase(String dir,String databaseName){
		
		List<String> tableNames =  findTableName(databaseName);
		
		for(String tableName : tableNames){
			//java 代码字符串
			String javastr = generatorBeanStr(tableName,databaseName);
			
			try {
				WriteFile.WriteBeanFile(dir, tableName, javastr);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return "";
	}
	
	
	/**
	 * 根据表生成单个对应的bean
	 * @param tableName 表的名称-数据库表的名称
	 * @param databaseName 数据库的名称
	 * @return
	 */
	public String generatorBeanStr(String tableName,String databaseName){
		
		List<ColumnMysql> propertyList =  null;
		
		
		propertyList  =  this.findColumnName(tableName,databaseName);	
		
		
		StringBuffer content = new StringBuffer();
		
		//引入...
		
		//添加bean名称头
		tableName = tableName.substring(0, 1).toUpperCase()+tableName.substring(1, tableName.length());
		
		content.append("public class  "+tableName+"{\n ");
		content.append("\n");
		
		//生成属性
		for(ColumnMysql node :  propertyList){
			//在属性的上边添加属性
			if(StringUtils.isNotBlank(node.getColumnComment())){
				content.append("/** "+node.getColumnComment()+"  */\n");
			}
			
			
			//添加属性
			content.append("private  "+node.getColumnType()+" "+node.getColumnName()+";\n");
			content.append("\n");
		}
		
		
		//生成getter和setter方法
		for(ColumnMysql node :  propertyList){
			
			String firstNodeUpper = node.getColumnName().substring(0, 1).toUpperCase();
			String firstNodeLower = node.getColumnName().substring(0, 1).toLowerCase();
			String lastNode = node.getColumnName().substring(1, node.getColumnName().length());
			
			//生成getter方法
			//前面getter
			content.append("public  "+node.getColumnType()+"  get"+firstNodeUpper+""
					+lastNode+"(){\n");
			
			content.append("    return  node.getColumnName();\n");
			
			content.append("}\n");
			content.append("\n");
			
			//setter方法
			content.append("public  void  set"+firstNodeUpper+""
					+lastNode+"("+ColumnDataUtil.parseColumnToJava(node.getColumnType())+"  "+ node.getColumnName()+"   ){\n");
			content.append("    this."+node.getColumnName() +"= "+node.getColumnName()+";");
			content.append("    \n");
			
			content.append("}\n");
			content.append("\n");
			
		}
		
		//bean结尾标志
		content.append("\n} ");
		
		return content.toString();
		
	}
	
	

}
