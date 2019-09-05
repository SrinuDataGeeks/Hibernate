package com.datageeks.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
	
	private SessionFactory sessionFactory = HBUtil.getSessionFactory();
	
	public void synchronization()
	{
		Session session = sessionFactory.openSession();
		ProductBean productBean = session.get(ProductBean.class, 111);
		System.out.println("\n\n ****Before Change ProductBean :: "+productBean);
		session.beginTransaction();
		productBean.setProductName("LenG570");
		session.flush();
		session.getTransaction().commit();
		System.out.println("\n\n ****After Change ProductBean :: "+productBean);
		session.close();
	}
	
	public void removedState()
	{
		Session session = sessionFactory.openSession();
		ProductBean productBean = session.get(ProductBean.class, 111);
		System.out.println("\n\n ****Before Change ProductBean :: "+productBean);
		session.beginTransaction();
		session.evict(productBean);
		productBean.setProductName("Apple4s");
		session.flush();
		session.getTransaction().commit();
		System.out.println("\n\n ****After Change ProductBean :: "+productBean);
		session.close();
	}
	
	

}
