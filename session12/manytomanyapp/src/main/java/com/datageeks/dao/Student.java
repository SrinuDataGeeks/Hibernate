package com.datageeks.dao;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "STUDENT")
public class Student  implements Serializable{
	
	@Id
	@Column(name = "STUDENT_ID")
	private Integer studentId = null;
	
	@Column(name = "STUDENT_NAME")
	private String studentName = null;
	
	@ManyToMany( cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(
			name = "STUDENT_COURSE",
			joinColumns = {@JoinColumn(name = "STUDENT_FK_ID")},
			inverseJoinColumns = {@JoinColumn(name = "COURSE_FK_ID")}
			)
	private Set<Course> courseSet = null;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set<Course> getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}
	
		

}
