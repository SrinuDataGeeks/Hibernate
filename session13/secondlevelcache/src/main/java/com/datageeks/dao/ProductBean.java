package com.datageeks.dao;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "PRODUCT")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ProductBean  implements Serializable {

		@Id
		@GenericGenerator(name = "icr" , strategy = "increment")
		@GeneratedValue(generator ="icr" )
		@Column(name = "PID")
	private Integer productId = null;
		
		@Column(name = "PNAME")
	private String productName = null;
		
		@Column(name = "PRICE")
	private Float productPrice = null;

	public ProductBean() {

	}
	
	

	public ProductBean(Integer productId, String productName, Float productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	


	public ProductBean(String productName, Float productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}



	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}

}
