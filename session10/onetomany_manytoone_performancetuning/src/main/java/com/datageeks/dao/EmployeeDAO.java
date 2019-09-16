package com.datageeks.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import oracle.net.aso.e;

public class EmployeeDAO {

	private SessionFactory sessionFactory = HBUtil.getSessionFactory();

	public void saveOrUpdate(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
		session.close();

	}

	public Employee get(Integer employeeId) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);
		session.close();
		return employee;
	}

	public void delete(Integer employeeId) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);
		if (employee != null) {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
		}
		session.close();
	}	

	public List<Employee> getAll() {
		Session session = sessionFactory.openSession();
		List<Employee> employeeList = session.createQuery("Select emp From Employee as emp", Employee.class)
				.getResultList();

		session.close();

		return employeeList;
	}

}
