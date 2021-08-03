package com.studentinfo.dao;

import java.util.List;

public class StudentInfoDTO {
	
	private String id;
    private String firstName;
    private String lastName;
    private long studentNumber;
    private String email;
    private List<String> courseList;
    private float gpa;
    
    
	public StudentInfoDTO() {
	
	}
	
	public StudentInfoDTO(String id, String firstName, String lastName, long studentNumber, String email,
			List<String> courseList, float gpa) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentNumber = studentNumber;
		this.email = email;
		this.courseList = courseList;
		this.gpa = gpa;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(long studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
	 @Override
	 public String toString() {
		 return "StudentInfoDTO{" +
				 "id='" + id + '\'' +
				 ", name='" + firstName + lastName + '\'' +
				 ", studentNumber=" + studentNumber +
				 ", email='" + email + '\'' +
				 ", courseList=" + courseList +
				 ", gpa=" + gpa +
				 '}';
	 } 

}