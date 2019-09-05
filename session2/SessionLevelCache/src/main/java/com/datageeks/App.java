package com.datageeks;

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
    		
    		dao.sessionLevelCache();
    }
}
