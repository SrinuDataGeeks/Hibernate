package com.datageeks.dao;

public class OrderDetails {
	
	private Integer orderDetailsId = null;
	private String city = null;
	private String location = null;
	private Order orderRef = null;
	
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(  String city, String location) {
		super();
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
	public Order getOrderRef() {
		return orderRef;
	}
	public void setOrderRef(Order orderRef) {
		this.orderRef = orderRef;
	}
	

	
	
}
