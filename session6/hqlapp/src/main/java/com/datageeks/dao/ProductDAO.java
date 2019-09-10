package com.datageeks.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {

	SessionFactory sessionFactory = HBUtil.getSessionFactory();

	public List<ProductBean> getAll() {
		List<ProductBean> productList = null;
		String hql = " Select  p From ProductBean as p";

		Session session = sessionFactory.openSession();

		TypedQuery<ProductBean> query = session.createQuery(hql, ProductBean.class);

		productList = query.getResultList();

		return productList;
	}
	
	public List<ProductBean> pagination() {
		List<ProductBean> productList = null;
		String hql = " Select  p From ProductBean as p";

		Session session = sessionFactory.openSession();

		TypedQuery<ProductBean> query = session.createQuery(hql, ProductBean.class);
		
		query.setFirstResult(2);
		query.setMaxResults(3);

		productList = query.getResultList();

		return productList;
	}

	public List<ProductBean> search(String productName) {
		List<ProductBean> productList = null;
		String hql = " Select  p From ProductBean as p where upper(p.productName) like :name";

		Session session = sessionFactory.openSession();

		TypedQuery<ProductBean> query = session.createQuery(hql, ProductBean.class);
		query.setParameter("name", "%" + productName.trim().toUpperCase() + "%");

		productList = query.getResultList();

		return productList;
	}

	public List<String> getProductNames() {
		List<String> productNamesList = null;
		String hql = " Select  p.productName From ProductBean as p";

		Session session = sessionFactory.openSession();

		TypedQuery<String> query = session.createQuery(hql, String.class);

		productNamesList = query.getResultList();

		return productNamesList;
	}

	public List<Object[]> getIdNames() {
		List<Object[]> productIdNamesList = null;
		String hql = " Select  p.productId, p.productName From ProductBean as p";

		Session session = sessionFactory.openSession();

		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);

		productIdNamesList = query.getResultList();

		return productIdNamesList;
	}

	public List<SearchCriteriaBean> getIdNamesRelaTimeUseCase() {
		List<SearchCriteriaBean> searchList = new ArrayList<SearchCriteriaBean>();

		List<Object[]> objArrayList = null;
		String hql = " Select  p.productId, p.productName From ProductBean as p";

		Session session = sessionFactory.openSession();
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		objArrayList = query.getResultList();

		for (Object[] objArray : objArrayList) {
			SearchCriteriaBean searchBean = new SearchCriteriaBean();
			searchBean.setProductId((Integer) objArray[0]);
			searchBean.setProductName((String) objArray[1]);

			searchList.add(searchBean);
		}

		return searchList;
	}

	public Float getMaxPrice() {
		Float maxPrice = null;
		String hql = " Select  max(p.productPrice) From ProductBean as p";

		Session session = sessionFactory.openSession();

		TypedQuery<Float> query = session.createQuery(hql, Float.class);

		maxPrice = query.getSingleResult();

		return maxPrice;
	}

	public ProductBean getById(Integer productId) {
		ProductBean productBean = null;
		String hql = " Select  p From ProductBean as p where p.productId = :id";

		Session session = sessionFactory.openSession();

		TypedQuery<ProductBean> query = session.createQuery(hql, ProductBean.class);
		query.setParameter("id", productId);

		productBean = query.getSingleResult();

		return productBean;
	}
	
	public Integer updatePrice()
	{
		Integer count = 0;
		
	String hql = " update ProductBean as p  set p.productPrice = p.productPrice + :increment "
			+ "	where p.productPrice <= :minimum ";

		Session session = sessionFactory.openSession();

			session.beginTransaction();
		Query	  query = session.createQuery(hql);
		query.setParameter("increment", 2500f);
		query.setParameter("minimum", 16000f);
		
		count = query.executeUpdate();
		session.getTransaction().commit();
		return count;
	}
	
	public List<ProductBean> demoOnNamedQuery() {
		List<ProductBean> productList = null;

		Session session = sessionFactory.openSession();

		TypedQuery<ProductBean> query = session.getNamedQuery("findProducts");

		productList = query.getResultList();

		return productList;
	}
}
