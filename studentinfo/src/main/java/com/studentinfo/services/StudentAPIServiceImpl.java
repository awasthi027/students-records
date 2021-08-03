package com.studentinfo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentinfo.models.StudentInfo;
import com.studentinfo.respositories.StudentDOARepository;




@Service
public class StudentAPIServiceImpl implements StudentAPIService {
	@Autowired
	private StudentDOARepository studentRepository;

	@Override
	public List<StudentInfo> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public StudentInfo findByStudentNumber(long studentNumber) {
		return studentRepository.findByStudentNumber(studentNumber);
	}

	@Override
	public StudentInfo findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Override
	public List<StudentInfo> findAllByOrderByGpaDesc() {
		return studentRepository.findAllByOrderByGpaDesc();
	}


	@Override
	public StudentInfo saveOrUpdateStudent(StudentInfo student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(String id) {
		studentRepository.deleteById(id);
	}

	@Override
	public StudentInfo updateStudentNumber(String  id, StudentInfo student) {
		if (studentRepository.findById(id).isPresent()){
			StudentInfo existStudent = studentRepository.findById(id).get();

			existStudent.setStudentNumber(student.getStudentNumber());

			return studentRepository.save(existStudent);

		} else{
			return null;
		}

	}


}
