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
    		
    		ProductBean product = dao.getByID(1112);
    			if(product == null)
    			{
    				System.out.println(" Invalid ID ");
    			}else
    			{
    				System.out.println(product);
    			}
    }
}
