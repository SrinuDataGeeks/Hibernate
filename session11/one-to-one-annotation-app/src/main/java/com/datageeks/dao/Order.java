package com.datageeks.dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="PLACE_ORDER")
public class Order implements Serializable{

		@Id	
		@Column(name="ORDER_ID")
	private Integer orderId = null;
		
		@Column(name="ORDER_BY")
	private  String orderBy = null;
	
			@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
			@JoinColumn(name="ORDER_DETAILS_FK_ID")
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
