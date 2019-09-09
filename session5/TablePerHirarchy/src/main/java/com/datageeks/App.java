package com.datageeks;

import com.datageeks.dao.ContractEmployee;
import com.datageeks.dao.Employee;
import com.datageeks.dao.EmployeeDAO;
import com.datageeks.dao.RegularEmployee;

/**	
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	Employee emp = new Employee(1242, "Srinu");
    	
    	RegularEmployee regemp = new RegularEmployee(1254, "Tirumal",5000f,800f);
    	
    	ContractEmployee conemp = new ContractEmployee(1240, "Rajeev","2 Year",1500f);
    	
    	EmployeeDAO dao = new EmployeeDAO();
    	
    	dao.save(emp);
    	dao.save(regemp);
    	dao.save(conemp);
		
    		
    		
    }
}
