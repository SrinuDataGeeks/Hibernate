package com.datageeks.dao;

public class Order {

	private Integer orderId = null;
	private String orderBy = null;
	private OrderDetails orderDetailsRef = null;
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Order(Integer orderId, String orderBy) {
		super();
		this.orderId = orderId;
		this.orderBy = orderBy;
	}



	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	public String getOrderBy() {
		return orderBy;
	}



	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}



	public OrderDetails getOrderDetailsRef() {
		return orderDetailsRef;
	}



	public void setOrderDetailsRef(OrderDetails orderDetailsRef) {
		this.orderDetailsRef = orderDetailsRef;
	}
	
	
	
}
