package com.slb.utill;

/**
 * 数据类型帮助类
 * @author sunlibao
 *
 */
public class ColumnDataUtil {
	
	/**
	 * 将数据库中表的类型转化为java基础的实际类型
	 * @param columnType 数据库表的类型
	 * @return
	 */
	public static  String  parseColumnToJava(String columnType){
		//java数据类型
		String javaData = "";
		
		switch (columnType) {
		case "int":
			javaData = "Integer";
			break;
		case "varchar":
			javaData = "String";
			break;

		default:
			break;
		}
		
		
		
		return "";
	}
	

}
