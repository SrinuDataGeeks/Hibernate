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
	
	public void save2(ProductBean product)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Integer id = (Integer)session.save("com.datageeks.dao.ProductBean",product);
		session.getTransaction().commit();
		session.close();
		
		System.out.println(id + " *** Insertion Successfull  with save ()");
		
	}
	
	public void persist(ProductBean product)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(product);
		session.getTransaction().commit();
		session.close();
		
		System.out.println(" With persist() record insertion is successfull");
	}
	
	public void get(Integer id)
	{
		Session session = sessionFactory.openSession();
		ProductBean product = session.get(ProductBean.class, id);
		System.out.println( " *** From get() :: ");
		System.out.println("productInfo :: "+product); //product.toString()
		session.close();
		
	}
	
	public void load(Integer id)
	{
		Session session = sessionFactory.openSession();
		ProductBean product = session.load(ProductBean.class, id);
		System.out.println( "  \n\n ***  From load() :: ");
		System.out.println("productInfo :: "+product.getProductName()); 
		session.close();
		
	}
	

	public void saveOrUpdate(ProductBean product)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate( product);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	public void delete(Integer id)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ProductBean product = session.get(ProductBean.class, id);
			if(product != null)
			{
				session.delete( product);
			}
					
		session.getTransaction().commit();
		session.close();
		
		
	}

}
