package com.org.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee
{
	@Id
	@Column(name = "EMP_ID")
	private Integer empId=null;
	@Column(name = "EMP_NAME")
	private String empName = null;
	@Column(name = "EMP_EMAIL")
	private String empEmail =null;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "ADDR_FK_ID")
	private Address address=null;
	
	/*
	
	Drop Table EMPLOYEE ;
	Drop Table ADDRESS;
	Create Table ADDRESS(ADDR_ID number(10) PRIMARY KEY, H_NO number(10),STREET varchar2(15),CITY varchar2(15),PIN_CODE number(6) );
	Create Table EMPLOYEE(EMP_ID number(10) Primary Key,EMP_NAME varchar2(15), EMP_EMAIL varchar2(15),ADDR_FK_ID number(10) references ADDRESS(ADDR_ID),Constraint ADDR_FK_ID_UNIQUE UNIQUE(ADDR_FK_ID) );

    */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empId, String empName, String empEmail) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}