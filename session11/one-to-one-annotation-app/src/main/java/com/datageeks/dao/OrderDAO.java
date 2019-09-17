package com.datageeks.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OrderDAO {

	private SessionFactory sessionFactory = HBUtil.getSessionFactory();

	public void saveOrUpdate(Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(order);
		session.getTransaction().commit();
		session.close();

	}

	public Order get(Integer orderId) {
		Session session = sessionFactory.openSession();
		Order order = session.get(Order.class, orderId);
		session.close();
		return order;
	}

	public void delete(Integer orderId) {
		Session session = sessionFactory.openSession();
		Order order = session.get(Order.class, orderId);
		if (order != null) {
			session.beginTransaction();
			session.delete(order);
			session.getTransaction().commit();
		}
		session.close();
	}

	public List<Order> getAll() {
		Session session = sessionFactory.openSession();
		List<Order> ordersList = session.createQuery("Select ord From Order as ord", Order.class).getResultList();

		session.close();

		return ordersList;
	}

}
