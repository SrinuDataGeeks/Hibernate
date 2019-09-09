package com.datageeks.dao;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private Integer empId = null;
	private String empName = null;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(Integer empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
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
	
	

}
