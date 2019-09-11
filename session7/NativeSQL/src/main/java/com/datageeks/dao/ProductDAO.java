package com.datageeks.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class ProductDAO {

	SessionFactory sessionFactory = HBUtil.getSessionFactory();

	@SuppressWarnings("unchecked")
	public List<String> getProductNames() {
		List<String> productNamesList = null;

		String sql = " Select PNAME From PRODUCT";

		Session session = sessionFactory.openSession();

		NativeQuery<String> query = session.createNativeQuery(sql);

		productNamesList = query.getResultList();

		return productNamesList;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getProductNames2() {
		
		return sessionFactory.openSession().createNativeQuery("Select PNAME From PRODUCT").getResultList();
	}

	public List<Object[]> getIdNames() {
		List<Object[]> productIdNamesList = null;

		String sql = " Select PID , PNAME From PRODUCT";

		Session session = sessionFactory.openSession();
		NativeQuery<Object[]> query = session.createNativeQuery(sql);
		query.addScalar("PID", IntegerType.INSTANCE);
		query.addScalar("PNAME", StringType.INSTANCE);

		productIdNamesList = query.getResultList();

		return productIdNamesList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getIdNames2() {
		
		return sessionFactory.openSession().createNativeQuery("Select PID, PNAME From PRODUCT")
												.addScalar("PID",IntegerType.INSTANCE)
												.addScalar("PNAME",StringType.INSTANCE).getResultList();
					
	}

	public List<SearchCriteriaBean> getIdNamesRelaTimeUseCase() {
		List<SearchCriteriaBean> searchList = new ArrayList<SearchCriteriaBean>();

		List<Object[]> objArrayList = null;

		String sql = " Select PID , PNAME From PRODUCT";

		Session session = sessionFactory.openSession();
		NativeQuery<Object[]> query = session.createNativeQuery(sql);
		query.addScalar("PID", IntegerType.INSTANCE);
		query.addScalar("PNAME", StringType.INSTANCE);

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

		String sql = " Select Max(PRICE) maxPrice From PRODUCT";

		Session session = sessionFactory.openSession();
		NativeQuery<Float> query = session.createNativeQuery(sql);
		query.addScalar("maxPrice", FloatType.INSTANCE);

		maxPrice = query.getSingleResult();

		return maxPrice;
	}

	public List<ProductBean> getAll() {
		List<ProductBean> productList = null;

		Session session = sessionFactory.openSession();

		NativeQuery<ProductBean> query = session.createNativeQuery("Select * From Product");
		query.addEntity(ProductBean.class);

		productList = query.getResultList();

		return productList;
	}

	public List<ProductBean> pagination() {
		List<ProductBean> productList = null;

		Session session = sessionFactory.openSession();

		NativeQuery<ProductBean> query = session.createNativeQuery("Select * From Product", ProductBean.class);
		query.setFirstResult(2);
		query.setMaxResults(3);

		productList = query.getResultList();

		return productList;
	}

	public List<ProductBean> search(String productName) {
		List<ProductBean> productList = null;

		Session session = sessionFactory.openSession();

		NativeQuery<ProductBean> query = session
				.createNativeQuery("Select * From Product Where upper(PNAME) like :name", ProductBean.class);
		query.setParameter("name", "%" + productName.trim().toUpperCase() + "%");

		productList = query.getResultList();

		return productList;
	}

	public ProductBean getById(Integer productId) {
		ProductBean productBean = null;

		Session session = sessionFactory.openSession();

		NativeQuery<ProductBean> query = session.createNativeQuery("Select * From Product Where  PID = :id",
				ProductBean.class);
		query.setParameter("id", productId);

		productBean = query.getSingleResult();

		return productBean;
	}

	public Integer updatePrice() {
		Integer count = 0;
		String sql = "Update PRODUCT SET PRICE = :maxPrice Where PRICE <= :minPrice";

		Session session = sessionFactory.openSession();

		NativeQuery query = session.createNativeQuery(sql);
		query.setParameter("maxPrice", 21000f);
		query.setParameter("minPrice", 18000f);

			session.beginTransaction();
		count = query.executeUpdate();
		session.getTransaction().commit();
		return count;
	}

}
