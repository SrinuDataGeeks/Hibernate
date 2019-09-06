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
    		
		/* save test cases 
		 
		 * ProductBean saveRecord = new ProductBean(001,"Apple5s",1500f);
		 * 
		 * ProductBean persistRecord = new ProductBean(002,"Apple6s",3500f);
		 * 
		 * dao.save(saveRecord);
		 * 
		 * dao.persist(persistRecord);
		 */
    		
		/*
		 * dao.get(1);
		 * 
		 * dao.load(2);
		 */
    		
		/*
		 * ProductBean saveOrupdateRecord = new ProductBean(003,"Apple8s",3500f);
		 * dao.saveOrUpdate(saveOrupdateRecord);
		 */
    		
		/*
		 * ProductBean deleteRecord = new ProductBean(); deleteRecord.setProductId(3);
		 * dao.delete(deleteRecord);
		 */
    		
    		
    }
}
