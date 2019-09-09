package com.datageeks.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {

	private SessionFactory sessionFactory = HBUtil.getSessionFactory();

	public ProductBean get(Integer id) throws DataSourceException {
		ProductBean productBean = null;

		try {
			productBean = sessionFactory.openSession().get(ProductBean.class, id);
		} catch (HibernateException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}

		return productBean;

	}

	public void saveOrUpdate(ProductBean product) throws DataSourceException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(product);
			session.getTransaction().commit();
		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} finally {
			if (session != null)
				session.close();
		}

	}

	public void delete(Integer id) throws DataSourceException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			ProductBean productBean = sessionFactory.openSession().get(ProductBean.class, id);
			if (productBean != null) {
				session.delete(productBean);
				session.getTransaction().commit();
			}

		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} finally {
			if (session != null)
				session.close();
		}

	}

	public List<ProductBean> search(String productName) throws DataSourceException {
		List<ProductBean> productList = null;
		Session session = null;

		String hql = " Select p From ProductBean p where upper(p.productName) like :pname";

		try {
			session = sessionFactory.openSession();
			TypedQuery<ProductBean> query = session.createQuery(hql, ProductBean.class);
			query.setParameter("pname", "%" + productName.trim().toUpperCase() + "%");

			productList = query.getResultList();

		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} finally {
			if (session != null)
				session.close();
		}

		return productList;
	}

	public List<ProductBean> getAll() throws DataSourceException {
		List<ProductBean> productList = null;
		Session session = null;

		String hql = " Select p From ProductBean p";

		try {
			session = sessionFactory.openSession();
			TypedQuery<ProductBean> query = session.createQuery(hql, ProductBean.class);
			productList = query.getResultList();

		} catch (HibernateException exp) {
			session.getTransaction().rollback();
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} finally {
			if (session != null)
				session.close();
		}

		return productList;
	}
	
	public ProductBean get2(Integer id) {
		return sessionFactory.openSession().get(ProductBean.class, id);
	}

	public void saveOrUpdate2(ProductBean product) throws DataSourceException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}

	public void delete2(Integer id) throws DataSourceException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ProductBean productBean = sessionFactory.openSession().get(ProductBean.class, id);
		if (productBean != null) {
			session.delete(productBean);
			session.getTransaction().commit();
		}

	}

	public List<ProductBean> search2(String productName) {
		String hql = " Select p From ProductBean p where upper(p.productName) like :pname";
		return sessionFactory.openSession().createQuery(hql, ProductBean.class)
				.setParameter("pname", "%" + productName.trim().toUpperCase() + "%").getResultList();
	}

	public List<ProductBean> getAll2() throws DataSourceException {
		String hql = " Select p From ProductBean p ";
		return sessionFactory.openSession().createQuery(hql, ProductBean.class)
				.getResultList();
	}

}
