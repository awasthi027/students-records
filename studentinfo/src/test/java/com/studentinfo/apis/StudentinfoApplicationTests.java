package com.studentinfo.apis;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studentinfo.models.StudentInfo;
import com.studentinfo.respositories.StudentDOARepository;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class StudentinfoApplicationTests {

	@Autowired 
	StudentDOARepository repository;
	
	public String email = "tanuja.awasthi3@gmail.com";
	
	@Test
	void contextLoads() {
	}
	@Order(1)
	@Test
	public void validateStudentInfo() {
		
		StudentInfo info = new StudentInfo();
		info.setFirstName("Ashish");
		info.setLastName("Awasthi");
		info.setStudentNumber(1);
		info.setEmail(email);
		List<String> courseList = Arrays.asList("Hindi",
	            "English",
	            "Math",
	            "Science",
	            "Social Science");
		info.setCourseList(courseList);
		info.setGpa((float) 1.0);
		repository.save(info);
		assertNotNull(repository.findByEmail(email).getId());
				
	}
	@Order(2)
	@Test
	public void  validateGetAllResult() {
		List <StudentInfo> list = repository.findAll();
		assertFalse(list.isEmpty());
	 }
	
	@Order(3)
	@Test
	public void testSingleStudentInfo() {
		StudentInfo info = repository.findByEmail(email);
		assertEquals(info.getEmail(), email);
	}
	
	@Order(4)
	@Test
	public void testUpdateStundentNumber() {
		StudentInfo info = repository.findByEmail(email);
		info.setStudentNumber(20);
		repository.save(info);
		assertEquals(repository.findByEmail(email).getStudentNumber(), 20);
	}
	
   @Order(5)
   @Test
   public void testDeleteStundentInfo() {
	   StudentInfo info = repository.findByEmail(email);
	   repository.deleteById(info.getId());
	   assertThat(repository.existsById(info.getId()));
   }
	

}

