package com.datageeks.service;

import java.util.List;

import com.datageeks.dao.DataSourceException;
import com.datageeks.dao.ProductBean;
import com.datageeks.dao.ProductDAO;

public class ProductService {

	ProductDAO dao = new ProductDAO();

	public List<ProductBean> search(String productName) throws ServicesException {
		List<ProductBean> productList = null;

		try {
			productList = dao.search(productName);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
		}
		return productList;
	}

	public void delete(Integer productId) throws ServicesException {

		try {
			dao.delete(productId);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
		}
	}

	public List<ProductBean> getAll() throws ServicesException {
		List<ProductBean> productList = null;

		try {
			productList = dao.getAll();
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
		}
		return productList;
	}

	public ProductBean get(Integer productId) throws ServicesException {
		ProductBean product = null;

		try {
			product = dao.get(productId);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
		}
		return product;
	}

	public void saveOrUpdate(ProductBean product) throws ServicesException {

		try {
			dao.saveOrUpdate(product);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicesException(exp.getMessage());
		}
	}
}
