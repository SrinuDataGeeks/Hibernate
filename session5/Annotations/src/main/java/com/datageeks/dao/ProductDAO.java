package com.datageeks.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
	
	private SessionFactory sessionFactory = HBUtil.getSessionFactory();
	
	public void save(ProductBean product)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Integer id = (Integer)session.save(product);
		session.getTransaction().commit();
		session.close();
		
		System.out.println(id + " *** Insertion Successfull  with save ()");
		
	}
	

}
