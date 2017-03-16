package com.slb.utill;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.slb.db.bean.ColumnMysql;

/**
 * 查询条件帮助类
 * @author sunlibao
 *
 */
public class QueryUtil {
	
	
	public static  String  parseColumnWhereSql(String tableName,List<ColumnMysql> columnList){
		
		StringBuffer sb = new StringBuffer();
		
		for(ColumnMysql nodeColumn : columnList){
			
			switch (nodeColumn.getColumnType()) {
			case "varchar":
				
				if(StringUtils.isNotBlank(nodeColumn.getColumnName())){
					sb.append("_"+tableName+"."+nodeColumn.getColumnName());
				}
				
				
				break;

			default:
				break;
			}
			
			
			
		}
		
		
		return "";
	}
	

}
