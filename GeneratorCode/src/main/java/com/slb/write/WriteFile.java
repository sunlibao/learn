package com.slb.write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



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
	public static void WriteBeanFile(String dir,String beanName,String javaStr) throws IOException{
			
			//生成文件
			
			File file = new File(dir+File.separator+beanName+".java");
			
			FileOutputStream  fileOutputStream = new FileOutputStream(file);
			
			fileOutputStream.write(javaStr.toString().getBytes());
		
	}
	
	
	public void test(){
		
		
	}
	

}
