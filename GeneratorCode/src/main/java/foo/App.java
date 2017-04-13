package foo;

import java.io.IOException;
import java.util.List;


import com.slb.db.bean.ColumnMysql;
import com.slb.db.bean.TableMysql;
import com.slb.generator.BeanGenereator;
import com.slb.generator.ServiceGenereator;
import com.slb.generator.ServiceImplGenereator;
import com.slb.write.WriteFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	BeanGenereator beanGenereator = new BeanGenereator();
    	
    	beanGenereator.writeBeanByDataBase("f://test/", "test");
    	
    }
    
    
    
    public void testDB(){
    	
    	BeanGenereator beanGenereator = new BeanGenereator();
    	
    	beanGenereator.writeBeanByDataBase("f://test/", "test");
    	
    	
    	//------------------
    	/*ServiceGenereator serviceGenereator = new ServiceGenereator();
    	
    	List<TableMysql>  result =  beanGenereator.findTableName("test");
    	
    	for(TableMysql tableMysql : result){
    		
    		List<ColumnMysql> columnMysqls  =  beanGenereator.findColumnName(tableMysql.getTableName(), "test");
    		
    		//String serviceStr = serviceGenereator.generatorServiceInterface(tableMysql, columnMysqls);
    		
    		String serviceImplStr = ServiceImplGenereator.generatorServiceImpl(tableMysql, columnMysqls);
    		
    		try {
				WriteFile.WriteBeanFile("f://test/", "UserServiceImpl", serviceImplStr);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}*/
    	
    	
    
    	
    	
    	
    	/*
    	try {
			WriteFile.WriteBeanFile("f://test/", tableName, propertyList);
		} catch (IOException e) {
			e.printStackTrace();
		}
    		
    		
    	}*/
    	
    	
    	
    	
    	
    }
    
    
}
