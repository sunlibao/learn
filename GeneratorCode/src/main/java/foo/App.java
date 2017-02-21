package foo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.slb.beanGenerator.BeanGenereator;
import com.slb.db.manager.DBUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	
    	
    }
    
    @Test
    public void testDB(){
    	
    	
    	BeanGenereator beanGenereator = new BeanGenereator();
    	
    	List<String> tableNames =  beanGenereator.findTableName("test");
    	
    	for(String tableName : tableNames){
    		System.out.println(tableName);
    	}
    	
    	
    }
    
    
}
