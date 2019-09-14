package com.datageeks;

import java.util.LinkedHashSet;
import java.util.Set;

import com.datageeks.dao.Department;
import com.datageeks.dao.DepartmentDAO;
import com.datageeks.dao.Employee;

/**	
 * Hello world!
 *
 */
public class DepartmentApp_OnetoManyRelationShip 
{
    public static void main( String[] args )
    {
    	DepartmentDAO departmentDAO = new DepartmentDAO();
    	
    	
    	 Department javaDepartment = new Department();
    	 javaDepartment.setDepartmentId(1);
    	 javaDepartment.setDepartmentName("Java");
    	
    	Employee employee1 = new Employee(1242,"Srinu","Sr:S/W");
    	Employee employee2 = new Employee(1240,"Sandeep","P.M");
    	Employee employee3 = new Employee(1241,"Aswini","S/W");
    	
    	Set<Employee> employeeSet = new LinkedHashSet<Employee>();
    	employeeSet.add(employee1);
    	employeeSet.add(employee2);
    	employeeSet.add(employee3);
    	
    	javaDepartment.setEmployeeSet(employeeSet);
    	
    	departmentDAO.saveOrUpdate(javaDepartment);
    	
    	 Department accDept = new Department();
    	 accDept.setDepartmentId(2);
    	 accDept.setDepartmentName("Accounting");
    	 departmentDAO.saveOrUpdate(accDept);
    	
    	/*
    	 Department dept = departmentDAO.get(1);
    	
    	System.out.println(dept.getDepartmentId() + "  :: "+dept.getDepartmentName());
    	
    	Set<Employee> employeeSet = dept.getEmployeeSet();
    	for(Employee emp : employeeSet)
    	{
    		System.out.println(emp);
    	}
    	 */
    	
    	//departmentDAO.delete(2);
    	
    	
    }	
}
