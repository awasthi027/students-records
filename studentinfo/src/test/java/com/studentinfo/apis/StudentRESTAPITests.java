package com.studentinfo.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentinfo.constants.GenericConstants;

import com.studentinfo.models.StudentInfo;

import com.studentinfo.services.StudentAPIService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import org.springframework.context.annotation.ComponentScan;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.studentinfo"})
@SpringBootTest
@AutoConfigureMockMvc

class StudentRESTAPITests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentAPIService studentAPIService;

    private List<StudentInfo> studentList;

    private  String email = "ashish.awasthi@gmail.com";

    @BeforeEach
    void setUp() {
        this.studentList = new ArrayList<>();
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
        this.studentList.add(info);
    }

    @Test
    void testFetchAllStudents() throws Exception {
      given(studentAPIService.findAll()).willReturn(studentList);
      this.mockMvc.perform(get("/students/")).andExpect(status().isOk());
    }
    
    @Test
    void testGetStudentByEmail() throws Exception {
         StudentInfo info = new StudentInfo();
        String uri = "/students/byEmail/{email}";
        when(studentAPIService.findByEmail(email)).thenReturn(info);
    }

     @Test
     void testCreateNewStudentInfo() throws  Exception {
         StudentInfo info = new StudentInfo();
         info.setFirstName("Ashish");
         info.setLastName("Awasthi");
         info.setStudentNumber(100);
         info.setEmail("ashish.awasthi@gmail.com");
         List<String> courseList = Arrays.asList("Hindi",
                 "English",
                 "Math",
                 "Science",
                 "Social Science");
         info.setCourseList(courseList);
         info.setGpa((float) 1.0);
        	ObjectMapper mapper = new ObjectMapper();
          Mockito.when(studentAPIService.saveOrUpdateStudent(ArgumentMatchers.any())).thenReturn(info);
             String json = mapper.writeValueAsString(info);
              mockMvc.perform(post("/students/save/").
                      contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                         .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                      .andExpect(content().string(GenericConstants.STUDENT_RECORD_SAVED));

     }
     @Test
     void  deleteStudentRecordsById() throws  Exception {
           String uri = "/students/deletebyId/{id}";
          ).thenReturn("Student is deleted"));


     }












}
