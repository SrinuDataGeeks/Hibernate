package com.datageeks.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDAO {
	
	SessionFactory sessionFactory = HBUtil.getSessionFactory();
	
	public void save(Employee employee)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		
	}

}
