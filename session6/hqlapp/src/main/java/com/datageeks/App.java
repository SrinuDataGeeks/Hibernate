package com.datageeks;

import java.util.List;

import com.datageeks.dao.ProductDAO;

public class App 
{
    public static void main( String[] args )
    {

    	ProductDAO dao = new ProductDAO();
    	
    	System.out.println(" getAll() => "+ dao.getAll()+"\n\n");
    	
    	System.out.println(" pagination() => "+ dao.pagination()+"\n\n");
    	
    	System.out.println(" search('Apple') => "+ dao.search("Apple")+"\n\n");
    	
    	System.out.println(" getProductNames() "+dao.getProductNames()+"\n\n");
    	
    	System.out.println("\n\n getProductIDNames() !!! List<Object[]> ");
    	
    		List<Object[]> objArrayList = dao.getIdNames();
    		for(Object[] objArray :objArrayList)
    		{
    			for(Object element: objArray)
    			{
    				System.out.print(element + " \t ");
    				
    			}
    			System.out.println();
    		}
    	
    		System.out.println("\n\n getIdNamesRelaTimeUseCase() !!!  List<SearchCriteriaBean> ");
    		System.out.println(dao.getIdNamesRelaTimeUseCase()+"\n\n");
    		
    		
    		
    		System.out.println("  MAXPRICE :: "+dao.getMaxPrice()+"\n\n");
    		System.out.println(" getById() "+dao.getById(111)+"\n\n");
    		
    		System.out.println("Non select query :: updatePrice()  updatedCount = "+dao.updatePrice());
    		
    		System.out.println(" demoOnNamedQuery() => "+ dao.demoOnNamedQuery()+"\n\n");
    }
}
