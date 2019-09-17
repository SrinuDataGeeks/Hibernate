package com.datageeks.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ORDER_DETAILS")
public class OrderDetails implements Serializable{

	@Id
	@Column(name = "ORDER_DETAILS_ID")
	private Integer orderDetailsId = null;
	
	@Column(name = "CITY")
	private String city = null;
	
	@Column(name = "LOCATION")
	private String location = null;
	

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(Integer orderDetailsId,String city, String location) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.city = city;
		this.location = location;
	}

	public Integer getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Integer orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
}
