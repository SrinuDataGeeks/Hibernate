package com.datageeks;

import java.util.List;

import com.datageeks.dao.Department;
import com.datageeks.dao.DepartmentDAO;
import com.datageeks.dao.Employee;
import com.datageeks.dao.EmployeeDAO;

public class EmployeeApp_ManyToOne {

	public static void main(String[] args) {
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		/*
		 Employee employee = new Employee(1254, "Tirumal", "Sr||Acc");
		Department department = departmentDAO.get(2);
		employee.setDepartment(department);
		
		employeeDAO.saveOrUpdate(employee);
		
		*/
		
	//employeeDAO.delete(1242);
		
		/*
		 Employee emp = employeeDAO.get(1241);
	
	System.out.println(emp.getEmployeeId()+ " : "+emp.getEmployeeName()+ " : "+emp.getEmployeeDesg());
	System.out.println(emp.getDepartment().getDepartmentId() + " : "+emp.getDepartment().getDepartmentName());
		 
		 */
		
		
		List<Employee> empList = employeeDAO.getAll();
		for(Employee emp : empList)
		{
			System.out.println("\n\n"+emp.getEmployeeId()+ " : "+emp.getEmployeeName()+ " : "+emp.getEmployeeDesg());
			System.out.println(emp.getDepartment().getDepartmentId() + " : "+emp.getDepartment().getDepartmentName());
				
		}
	
		
	}
}
