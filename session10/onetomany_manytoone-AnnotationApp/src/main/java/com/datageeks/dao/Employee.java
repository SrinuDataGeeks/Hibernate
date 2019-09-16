package com.datageeks.dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
	
	@Id
	@Column(name = "EMP_ID")
	private Integer employeeId = null;
	
	@Column(name = "EMP_NAME")
	private String employeeName = null;
	
	@Column(name = "EMP_DESG")
	private String employeeDesg = null;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPT_FK_ID")
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
