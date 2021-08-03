package com.studentinfo.respositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.studentinfo.models.StudentInfo;



public interface StudentDOARepository extends MongoRepository<StudentInfo, String> {
	
	StudentInfo findByStudentNumber(long studentNumber);

	StudentInfo findByEmail(String email);

	List<StudentInfo> findAllByOrderByGpaDesc();
}
