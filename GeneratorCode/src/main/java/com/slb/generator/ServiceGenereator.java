package com.slb.generator;

import java.util.List;

import com.slb.db.bean.ColumnMysql;
import com.slb.db.bean.TableMysql;

/**
 * service生成
 * @author sunlibao
 *
 */
public class ServiceGenereator {
	
	
	
	/**
	 * 初始化service接口层
	 * @param tableMysql 数据库表对象
	 * @param columnMysql 列对象
	 * @return 拼接好的字符串
	 */
	public String generatorServiceInterface(TableMysql tableMysql ,List<ColumnMysql> columnList){
		
		StringBuffer sb = new StringBuffer();
		
		
		String tableName = tableMysql.getTableName();
		
		String beanName = tableName.substring(0,1).toUpperCase()+tableName.substring(1, tableName.length());
		
		String serviceName = beanName +"Servcie";
		
		
		
		//头文件
		sb.append("public interface  "+serviceName+"{\n");	
		
		
		//初始化话接口中的各种方法
		sb.append(generatorQuery(beanName, columnList));
		
	
		//初始化保存方法
		sb.append(generatorSave(beanName, columnList));
		
		
		//初始化删除方法
		sb.append(generatorDelete(beanName, columnList));
		
		
		
		sb.append("\n}");
		
		
		return sb.toString();
	}
	
	
	
	/**
	 * 初始化查询方法
	 * @param beanName 对象的名称
	 * @param columnList 列字段
	 * @return 查询的sql字符串
	 */
	private String generatorQuery(String beanName, List<ColumnMysql> columnList){
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("/** 查询所有的  */\n");
		//查询所有字段的方
		sb.append("public List<"+beanName+">  findAll"+beanName+"("+beanName  +"   "+beanName.substring(0, 1).toLowerCase()+
				beanName.substring(1)+"){}\n");
		
		
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
