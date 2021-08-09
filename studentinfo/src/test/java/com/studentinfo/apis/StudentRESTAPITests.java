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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

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
    private  String baseURI = "/students/";
    private StudentInfo createTestStudentObject() {
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
        return  info;
    }

    @BeforeEach
    void setUp() {
        this.studentList = new ArrayList<>();
        this.studentList.add(this.createTestStudentObject());
    }

    @Test
    void testFetchAllStudents() throws Exception {
        given(studentAPIService.findAll()).willReturn(studentList);
        this.mockMvc.perform(get(baseURI)).andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is("Ashish")));

    }

    @Test
    void testValidateStudentInfo() throws Exception {
        given(studentAPIService.findAll()).willReturn(studentList);
        mockMvc.perform(get(baseURI )
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName",is("Ashish")));
    }
    
    @Test
    void testGetStudentByEmail() throws Exception {
         StudentInfo info = this.createTestStudentObject();
        String uri = baseURI + "byEmail/{email}";
        when(studentAPIService.findByEmail(email)).thenReturn(info);
        mockMvc.perform(get(uri, email )
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName",is("Ashish")));
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
    public void testDeleteStudentById() throws Exception {
        String uri = baseURI + "deletebyId/610a12e8f9fb2c72f9b0b558";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, GenericConstants.STUDENT_INFO_DELETE);
    }

}
