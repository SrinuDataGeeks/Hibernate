package com.datageeks.dao;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private Integer employeeId = null;
	private String employeeName = null;
	private String employeeDesg = null;
	
	private Department department = null;

	public Employee(Integer employeeId, String employeeName, String employeeDesg) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDesg = employeeDesg;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesg() {
		return employeeDesg;
	}

	public void setEmployeeDesg(String employeeDesg) {
		this.employeeDesg = employeeDesg;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDesg="
				+ employeeDesg + "]";
	}

	

}
