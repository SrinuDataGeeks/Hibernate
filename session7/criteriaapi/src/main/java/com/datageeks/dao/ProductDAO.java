package com.datageeks.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {

	SessionFactory sessionFactory = HBUtil.getSessionFactory();
	
	public List<String> getProductNames() {
		List<String> productNamesList = null;

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
		Root<ProductBean> root =	criteriaQuery.from(ProductBean.class);
		criteriaQuery.select(root.get("productName"));
		TypedQuery<String> query = session.createQuery(criteriaQuery);
		productNamesList = query.getResultList();

		return productNamesList;
	}

	public List<Object[]> getIdNames() {
		List<Object[]> productIdNamesList = null;

		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		criteriaQuery.multiselect(root.get("productId"), root.get("productName"));

		TypedQuery<Object[]> query = session.createQuery(criteriaQuery);

		productIdNamesList = query.getResultList();

		return productIdNamesList;
	}

	public List<SearchCriteriaBean> getIdNamesRelaTimeUseCase() {
		List<SearchCriteriaBean> searchList = new ArrayList<SearchCriteriaBean>();

		List<Object[]> objArrayList = null;
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		criteriaQuery.multiselect(root.get("productId"), root.get("productName"));
		TypedQuery<Object[]> query = session.createQuery(criteriaQuery);
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

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Float> criteriaQuery = builder.createQuery(Float.class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		
		criteriaQuery.select(builder.max(root.get("productPrice")));

		TypedQuery<Float> query = session.createQuery(criteriaQuery);

		maxPrice = query.getSingleResult();

		return maxPrice;
	}

	public List<ProductBean> getAll() {
		List<ProductBean> productList = null;

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> criteriaQuery = builder.createQuery(ProductBean.class);
		Root<ProductBean> root =	criteriaQuery.from(ProductBean.class);
		criteriaQuery.select(root);
		
		TypedQuery<ProductBean> query = session.createQuery(criteriaQuery);
		productList = query.getResultList();

		return productList;
	}
	
	public List<ProductBean> pagination() {
		List<ProductBean> productList = null;

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> criteriaQuery = builder.createQuery(ProductBean.class);
		Root<ProductBean> root =	criteriaQuery.from(ProductBean.class);
		criteriaQuery.select(root);
		
		TypedQuery<ProductBean> query = session.createQuery(criteriaQuery);
		
		query.setFirstResult(2);
		query.setMaxResults(3);

		productList = query.getResultList();

		return productList;
	}

	public List<ProductBean> search(String productName) {
		List<ProductBean> productList = null;

		Session session = sessionFactory.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> criteriaQuery = builder.createQuery(ProductBean.class);
		Root<ProductBean> root =	criteriaQuery.from(ProductBean.class);
		criteriaQuery.select(root).where(builder.like(root.get("productName"),  "%" + productName.trim().toUpperCase() + "%"));
		TypedQuery<ProductBean> query = session.createQuery(criteriaQuery);
		

		productList = query.getResultList();

		return productList;
	}

	

	public ProductBean getById(Integer productId) {
		ProductBean productBean = null;

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ProductBean> criteriaQuery = builder.createQuery(ProductBean.class);
		Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
		
		criteriaQuery.select(root).where(builder.equal(root.get("productId"), productId));

		TypedQuery<ProductBean> query = session.createQuery(criteriaQuery);

		productBean = query.getSingleResult();

		return productBean;
	}
	
	public Integer updatePrice()
	{
		Integer count = 0;
		

		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<ProductBean> criteriaUpdate = builder.createCriteriaUpdate(ProductBean.class);
		Root<ProductBean> root = criteriaUpdate.from(ProductBean.class);
		
		criteriaUpdate.set(root.get("productPrice"), 18000f);
		criteriaUpdate.where(builder.lessThan(root.get("productPrice"), 18000f));
		
			session.beginTransaction();
		Query	  query = session.createQuery(criteriaUpdate);
		
		count = query.executeUpdate();
		session.getTransaction().commit();
		return count;
	}
	

}
