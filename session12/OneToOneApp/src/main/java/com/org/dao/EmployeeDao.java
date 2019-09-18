package com.org.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDao {
	
	private SessionFactory sf=HBUtil.getSessionFactory();
	
	
	
	public Employee get(Integer empId){
		
		return  sf.openSession().get(Employee.class, empId);
		
		}
	
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAll(){
		
		List<Employee> empList = sf.openSession().createQuery("select emp from Employee as emp").getResultList();
		
		return empList;
	}
	
	public void saveOrUpdate(Employee employee) {
		
		Session session=sf.openSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(employee);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	public void delete(Integer empId) {
		
		Session session=sf.openSession();
		
		Employee employee=session.get(Employee.class, empId);
		
		if(employee != null) {
			
			session.delete(employee);
			
			session.getTransaction().commit();
			
		}
		session.close();

	}
	
	
}
