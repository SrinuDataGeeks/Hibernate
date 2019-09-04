package com.datageeks.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {
	
	private SessionFactory sessionFactory = HBUtil.getSessionFactory();
	
	public ProductBean getByID(Integer productId)
	{
		ProductBean productBean = null;
		Session session = sessionFactory.openSession();
		productBean = session.get(ProductBean.class, productId);
			if(productBean  != null)
			{
					session.beginTransaction();
				
				productBean.setProductName("Test-Np");
				
					session.getTransaction().commit();
			}
		session.close();
		return productBean;
	}

}
