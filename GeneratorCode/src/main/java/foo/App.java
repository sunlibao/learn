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

import com.slb.db.bean.ColumnMysql;
import com.slb.db.bean.TableMysql;
import com.slb.db.manager.DBUtil;
import com.slb.generator.BeanGenereator;
import com.slb.generator.ServiceGenereator;
import com.slb.write.WriteFile;

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
    	
    	//beanGenereator.writeBeanByDataBase("f://test/", "test");
    	
    	
    	//------------------
    	ServiceGenereator serviceGenereator = new ServiceGenereator();
    	
    	List<TableMysql>  result =  beanGenereator.findTableName("test");
    	
    	for(TableMysql tableMysql : result){
    		
    		List<ColumnMysql> columnMysqls  =  beanGenereator.findColumnName(tableMysql.getTableName(), "test");
    		
    		String serviceStr = serviceGenereator.generatorServiceInterface(tableMysql, columnMysqls);
    		
    		
    		try {
				WriteFile.WriteBeanFile("f://test/", "UserService", serviceStr);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    	
    	
    
    	
    	
    	
    	/*
    	try {
			WriteFile.WriteBeanFile("f://test/", tableName, propertyList);
		} catch (IOException e) {
			e.printStackTrace();
		}
    		
    		
    	}*/
    	
    	
    	
    	
    	
    }
    
    
}
