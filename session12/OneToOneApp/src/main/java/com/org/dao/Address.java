package com.org.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")

public class Address
{
	@Id
	@Column(name = "ADDR_ID")
	private Integer addId=null;
	
	@Column(name = "H_NO")
	private Integer hNo= null;
	
	@Column(name = "STREET")
	private String street = null;
	
	@Column(name = "CITY")
	private String city = null;
	
	@Column(name = "PIN_CODE")
	private Integer pincode = null;
	
	// Create Table ADDRESS(ADDR_ID number(10) PRIMARY KEY, H_NO number(10),STREET varchar2(15),CITY varchar2(15),PIN_CODE number(6) );
	

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address( Integer addId ,Integer hNo,String street, String city, Integer pincode) {
		super();
		this.addId = addId;
	    this.hNo = hNo;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	
	}
	
	public Integer getAddId() {
		return addId;
	}
	
	public void setAddId(Integer addId) {
		this.addId=addId;
	}
	
	public Integer getHNo() {
		return hNo;
	}
	
	public void setHNo(Integer hNo) {
		
		this.hNo=hNo;
	}

	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	
	
	
}