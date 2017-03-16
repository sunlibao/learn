package com.slb.generator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.slb.db.bean.ColumnMysql;
import com.slb.db.bean.TableMysql;
import com.slb.db.manager.DBUtil;

/**
 * service实现类代码生成
 * @author sunlibao
 *
 */
public class ServiceImplGenereator {
	
	/**
	 * 初始化service实现类
	 * @param tableMysql 数据库表对象
	 * @param columnMysql 列对象
	 * @return 拼接好的字符串
	 */
	public String generatorServiceImpl(TableMysql tableMysql ,List<ColumnMysql> columnList){
		
		StringBuffer sb = new StringBuffer();
		
		
		String tableName = tableMysql.getTableName();
		
		String beanName = tableName.substring(0,1).toUpperCase()+tableName.substring(1, tableName.length());
		
		//接口的方法名称
		String serviceName = beanName +"Servcie";
		//接口实现的方法名称
		String serviceImplName = beanName +"ServcieImpl";
		
		//头文件
		sb.append("public class  "+serviceImplName+" implements  "+serviceName+ " {\n");	
		
		
		//初始化话接口中的各种方法
		sb.append(generatorQuery(beanName,tableName ,columnList));
		
	
		//初始化保存方法
		//sb.append(generatorSave(beanName, columnList));
		
		
		//初始化删除方法
		//sb.append(generatorDelete(beanName, columnList));
		
		
		
		sb.append("\n}");
		
		
		return sb.toString();
	}
	
	
	
	/**
	 * 初始化查询方法
	 * @param beanName 对象的名称
	 * @param tableName 表名
	 * @param columnList 列字段
	 * @return 查询的sql字符串
	 * @throws Execption
	 */
	private String generatorQuery(String beanName,String tableName, List<ColumnMysql> columnList){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("/** 查询所有的  */\n");
		//查询所有字段的方
		sb.append("public List<"+beanName+">  findAll"+beanName+"("+beanName  +"   "+beanName.substring(0, 1).toLowerCase()+
				beanName.substring(1)+"){"
						+ "");
		
		//具体的实现方法
		
		Connection conn;
		try {
			
			StringBuffer sbsql = new StringBuffer("select  *   from "+tableName+"");
			
			boolean flag = false;
			
			for(ColumnMysql nodeColumn :  columnList){
				if(StringUtils.isNotBlank(nodeColumn.getColumnName())){
					sbsql.append(" "+nodeColumn.getColumnName() +" = ? ,");
					flag = true;
				}
			}
			
			//去除查询语句后面多余的逗号
			if(flag){
				sbsql = new StringBuffer(sbsql.subSequence(0, sbsql.length()-1));
			}
			
			
			conn = DBUtil.getConnection();
			PreparedStatement ps =  conn.prepareStatement(sbsql.toString());
			
			for(int i= 0 ; i < columnList.size() ; i++ ){
				
				if(StringUtils.isNotBlank(columnList.get(i).getColumnName())){
					
					ps.setObject(i, columnList.get(i).getColumnName());
					
				}
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		sb.append("}\n");
		
		
		return sb.toString();
	}
	
	
	/**
	 * 初始化保存方法
	 * @param beanName 对象的名称
	 * @param columnList 列字段
	 * @return 查询的sql字符串
	 */
	private String generatorSave(String beanName, List<ColumnMysql> columnList){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("/** 保存接口  */\n");
		//查询所有字段的方
		sb.append("public "+beanName+"  save"+beanName+"("+beanName  +"   "+beanName.substring(0, 1).toLowerCase()+
				beanName.substring(1)+"){}\n");
		
		return sb.toString();
	}
	
	
	/**
	 * 初始化保存方法
	 * @param beanName 对象的名称
	 * @param columnList 列字段
	 * @return 查询的sql字符串
	 */
	private String generatorDelete(String beanName, List<ColumnMysql> columnList){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("/** 保存接口  */\n");
		//查询所有字段的方
		sb.append("public "+beanName+"  delete"+beanName+"("+beanName  +"   "+beanName.substring(0, 1).toLowerCase()+
				beanName.substring(1)+"){}\n");
		
		return sb.toString();
	}
	

}
