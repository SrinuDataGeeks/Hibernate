package com.org;

import com.org.dao.Address;
import com.org.dao.Employee;
import com.org.dao.EmployeeDao;

/**
 * Hello world!
 *
 */
public class EmployeeApp 
{
    public static void main( String[] args )
    {
    	
    	EmployeeDao dao=new EmployeeDao();
    	
    	Employee emp=new Employee(01,"VENKAT","venky@gmail.com");
    	
    	Address add=new Address(11,134,"KPHB","HYD",500001);
    	
    	
    	emp.setAddress(add);

    	dao.saveOrUpdate(emp);
    	
    }
}
