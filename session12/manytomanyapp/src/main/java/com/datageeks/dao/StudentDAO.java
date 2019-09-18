package com.datageeks.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentDAO {

	private SessionFactory sessionFactory = HBUtil.getSessionFactory();

	public void saveOrUpdate(Student student) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(student);
		session.getTransaction().commit();
		session.close();	

	}

	public Student get(Integer studentId) {
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, studentId);
		session.close();
		return student;
	}

	public void delete(Integer studentId) {
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, studentId);
		if (student != null) {
			session.beginTransaction();
			session.delete(student);
			session.getTransaction().commit();
		}
		session.close();
	}

	public List<Student> getAll() {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createQuery("Select std From Student as std", Student.class).getResultList();

		session.close();

		return studentList;
	}

}
