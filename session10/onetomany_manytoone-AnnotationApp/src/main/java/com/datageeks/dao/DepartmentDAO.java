package com.datageeks.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DepartmentDAO {

	private SessionFactory sessionFactory = HBUtil.getSessionFactory();

	public void saveOrUpdate(Department department) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(department);
		session.getTransaction().commit();
		session.close();

	}

	public Department get(Integer departmentId) {
		Session session = sessionFactory.openSession();
		Department dept = session.get(Department.class, departmentId);
		session.close();
		return dept;
	}

	public void delete(Integer departmentId) {
		Session session = sessionFactory.openSession();
		Department dept = session.get(Department.class, departmentId);
		if (dept != null) {
			session.beginTransaction();
			session.delete(dept);
			session.getTransaction().commit();
		}
		session.close();
	}

	public List<Department> getAll() {
		Session session = sessionFactory.openSession();
		List<Department> deptList = session.createQuery("Select dept From Department as dept", Department.class)
				.getResultList();

		session.close();

		return deptList;
	}

}
