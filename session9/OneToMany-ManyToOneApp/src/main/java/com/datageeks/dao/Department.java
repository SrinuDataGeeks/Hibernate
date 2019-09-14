package com.datageeks.dao;

import java.io.Serializable;
import java.util.Set;

public class Department implements Serializable{
	
	private Integer departmentId = null;
	private String departmentName = null;
	
	private Set<Employee> employeeSet = null;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Integer departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}

	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", employeeSet="
				+ employeeSet + "]";
	}
	
	

}
