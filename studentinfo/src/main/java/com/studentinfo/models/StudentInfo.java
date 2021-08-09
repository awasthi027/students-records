package com.studentinfo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "students")

public class StudentInfo {
	 @Id
	private String id;
	 
	private String firstName;

	private String lastName;
	
    private long studentNumber;
    
    private String email;
    
    private List<String> courseList;
    
	private float gpa;

	public StudentInfo(String firstName, String lastName, long studentNumber, String email, List<String> courseList,
			float gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentNumber = studentNumber;
		this.email = email;
		this.courseList = courseList;
		this.gpa = gpa;
	}

	public StudentInfo() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public StudentInfo(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	 @Override
	 public String toString() {
		 return "Student{" +
				 "id='" + id + '\'' +
				 ", name='" + firstName + lastName + '\'' +
				 ", studentNumber=" + studentNumber +
				 ", email='" + email + '\'' +
				 ", courseList=" + courseList +
				 ", gpa=" + gpa +
				 '}';
	 } 

}
