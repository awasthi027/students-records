package com.studentinfo.apis;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.studentinfo.models.StudentInfo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	public String email = "tanuja.awasthi@gmail.com";
	
	@Test
	public void testToValidateStudentRequest() throws Exception {
		String urlString = "http://localhost:" + port + "/" + "students/byEmail/" + email;
		System.out.println("Test Request URL:-\n" + urlString);
		StudentInfo info = this.restTemplate.getForObject(urlString,
				StudentInfo.class);
		assertNotNull(info.getEmail());
		assertNotNull(info.getFirstName());
		assertNotNull(info.getLastName());
		assertNotNull(info.getCourseList());
	}

}
