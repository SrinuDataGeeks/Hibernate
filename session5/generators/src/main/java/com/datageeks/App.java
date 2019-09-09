package com.datageeks;

import com.datageeks.dao.ProductBean;
import com.datageeks.dao.ProductDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		ProductDAO dao = new ProductDAO();
    		
		
		 
		 ProductBean saveRecord = new ProductBean("Apple5s",1500f);
		 dao.save(saveRecord);
		 
		
    		
    		
    }
}
