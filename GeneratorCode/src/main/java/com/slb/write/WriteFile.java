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
import com.slb.db.bean.ColumnMysql;
import com.slb.utill.ColumnDataUtil;

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
	
	@Test
	public void test(){
		
		
	}
	

}
