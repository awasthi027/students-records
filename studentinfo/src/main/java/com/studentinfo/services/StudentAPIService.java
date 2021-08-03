package com.studentinfo.services;



import java.util.List;

import com.studentinfo.models.StudentInfo;



public interface StudentAPIService {
	
	List<StudentInfo> findAll();

	StudentInfo findByStudentNumber(long studentNumber);

	StudentInfo findByEmail(String email);

    List<StudentInfo> findAllByOrderByGpaDesc();


    void deleteStudentById(String id);

	StudentInfo saveOrUpdateStudent(StudentInfo student);
	
	StudentInfo updateStudentNumber(String  id, StudentInfo student);
}
