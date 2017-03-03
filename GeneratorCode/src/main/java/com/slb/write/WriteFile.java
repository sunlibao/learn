package com.slb.write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mysql.jdbc.StringUtils;
import com.slb.beanGenerator.ColumnMysql;

/**
 * 文件写入类
 * @author sunlibao
 *
 */
public class WriteFile {
	
	
	/**
	 * 写bean文件
	 * @param dir 文件路径
	 * @param beanName  类的名称
	 * @param proterty 类中的属性
	 * @throws IOException 
	 */
	public static void WriteBeanFile(String dir,String beanName,List<ColumnMysql> proterty) throws IOException{
		
			StringBuffer content = new StringBuffer();
			
			
			//引入...
			
			
			//添加bean名称头
			beanName = beanName.substring(0, 1).toUpperCase()+beanName.substring(1, beanName.length());
			
			content.append("public class  "+beanName+"{\n ");
			content.append("\n");
			
			
			//生成属性
			for(ColumnMysql node :  proterty){
				content.append("private  "+node.getColumnType()+" "+node.getColumnName()+";\n");
				content.append("\n");
			}
			
			
			//生成getter和setter方法
			for(ColumnMysql node :  proterty){
				
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
				/*content.append("public  void  set"+firstNodeUpper+""
						+lastNode+"(){\n");
				content.append("this."+)
				content.append("    \n");*/
				
				content.append("}\n");
				content.append("\n");
				
				
			}
			
			//bean结尾标志
			content.append("\n} ");
			
			
			
			//生成文件
			
			File file = new File(dir+File.separator+beanName+".java");
			
			FileOutputStream  fileOutputStream = new FileOutputStream(file);
			
			fileOutputStream.write(content.toString().getBytes());
			
		
	}
	
	@Test
	public void test(){
		
		ColumnMysql columnMysql  =   new ColumnMysql();
		
		
		columnMysql.setColumnName("user");
		
		columnMysql.setColumnType("String");
		
		List<ColumnMysql> param = new ArrayList<>();
		
		param.add(columnMysql);
		
		
		WriteFile writeFile = new WriteFile();
		
		try {
			writeFile.WriteBeanFile("f://", "test", param);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
