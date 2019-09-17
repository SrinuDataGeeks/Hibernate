package com.datageeks;

import com.datageeks.dao.Order;
import com.datageeks.dao.OrderDAO;
import com.datageeks.dao.OrderDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	OrderDAO orderDAO = new OrderDAO();
    	
    	/*
    	 
    	Order order = new Order(111, "Srinu");
    	
    	OrderDetails orderDetails = new OrderDetails(111,"Hyd", "KPHP");
    	
    	order.setOrderDetailsRef(orderDetails);
    	
    	orderDAO.saveOrUpdate(order);
    	
    	*/
    	
    	/*
    	 
    	Order order = orderDAO.get(111);
    	System.out.println(order.getOrderBy() + ": "+order.getOrderDetailsRef().getCity());
    			*/
    	orderDAO.delete(111);
    }
}
