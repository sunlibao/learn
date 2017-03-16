package com.slb.db.manager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil { 
	
	private static Connection conn;

	
	public  static final  Connection  getConnection() throws IOException, ClassNotFoundException, SQLException{
		
		
		if(conn == null){
			//获得数据库连接
	    	Properties p = new Properties();
	    	
	    	InputStream is = ClassLoader.getSystemResourceAsStream("database.properties");
	    	
    		//加载数据库文件
			p.load(is);
			//驱动
			String driver = p.getProperty("data.driver");
			//数据库地址
			String url = p.getProperty("data.url");
			//用户名
			String user = p.getProperty("data.user");
			//密码
			String password = p.getProperty("data.pwd");
			
			//指定连接类型
			Class.forName(driver);
			
			//获得连接
			conn = DriverManager.getConnection(url, user, password);
				
		}
			
		
			return conn;
			
	}
	
	//关闭连接
	public void closeConn(Connection conn) throws SQLException{
		
		conn.close();
		
	}
	
	
	
	

}
