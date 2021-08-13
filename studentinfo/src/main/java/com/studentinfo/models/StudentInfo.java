package com.studentinfo.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "students")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString
public class StudentInfo {
	 @Id
	private String id;
	 
	private String firstName;

	private String lastName;
	
    private long studentNumber;
    
    private String email;
    
    private List<String> courseList;
    
	private float gpa;


}
