package com.slb.generator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.slb.db.bean.ColumnMysql;
import com.slb.db.bean.TableMysql;
import com.slb.db.manager.DBUtil;

import foo.User;

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
	public static String generatorServiceImpl(TableMysql tableMysql ,List<ColumnMysql> columnList){
		
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
	private static String generatorQuery(String beanName,String tableName, List<ColumnMysql> columnList){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("/** 查询所有的  */\n");
		//查询所有字段的方
		sb.append("public List<"+beanName+">  findAll"+beanName+"("+beanName  +"   "+beanName.substring(0, 1).toLowerCase()+
				beanName.substring(1)+"){"
						+ "");
		
		//具体的实现方法
		sb.append("\n");
		//添加sql信息---begin
		sb.append("StringBuffer sbsql = new StringBuffer(\"select   *  from  "+"user"+" \");");
		
		StringBuffer sbsql =  new StringBuffer();
		 
		//原来的sql查询
		sb.append("\n");
		sb.append("List<User> result = new ArrayList<User>(); \n"
				+ "try { \n "
				+ "\t Connection conn = DBUtil.getConnection(); \n"
				+ "\t Statement st = conn.createStatement(); "
				+ "\t ResultSet rs =  st.executeQuery(sbsql.toString()); \n  "
				+ "\t while(rs.next()){  ");
			
		
		String paramStr = "";
		
		//根据类型确认获得参数的方法
		for(ColumnMysql columnMysql : columnList){
			sb.append("\n");
			sb.append("\t String "+columnMysql.getColumnName() +" = "+" ");
			switch (columnMysql.getColumnType()) {
			case "String":
				sb.append("rs.getString(\""+columnMysql.getColumnName()+"\");");
				break;
			case "Integer":
				sb.append("rs.getString(\""+columnMysql.getColumnName()+"\");");
				break;
			default:
				sb.append("rs.getString(\""+columnMysql.getColumnName()+"\");");
				break;
			}
			
			paramStr += columnMysql.getColumnName()+",";
			
		}
		
		//获得参数 通过构造函数的方式添加进行数据的初始化--begin
		if(paramStr.length() > 0){
			paramStr = paramStr.substring(0, paramStr.length()-1);
		}
		sb.append("\n");
		sb.append(tableName + " " +tableName +" = new  "+tableName+"("+paramStr+");\n");
		sb.append("\n");
		//添加返回值
		sb.append("result.add("+tableName+");");
		sb.append("}\n");
		
		sb.append("} catch (Exception e) {");
		sb.append("e.printStackTrace();");
		
		sb.append("}\n");
		
		//返回返回值	
		sb.append("return result;");
		
		
		
		
		//方法的结束符号
		sb.append("\n}\n");
		
		
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
