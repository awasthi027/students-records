package com.studentinfo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.studentinfo.constants.GenericConstants;
import com.studentinfo.dao.StudentInfoDTO;
import com.studentinfo.genericvalidator.GenericValidator;
import com.studentinfo.models.StudentInfo;
import com.studentinfo.services.StudentAPIService;
import com.studentinfo.utils.Utils;



@RestController

@RequestMapping("/students")
public class StudentRestController {

	@Autowired
	StudentAPIService studentService;

	@GetMapping(value = "/")  
	public List<StudentInfoDTO> getAllStudents() {
		return Utils.mapAll(studentService.findAll(), StudentInfoDTO.class);
	}

	@GetMapping(value = "/byStudentNumber/{studentNumber}")
	public StudentInfoDTO getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber) {
		System.out.println("Student Number:-\n" + studentNumber);
		return Utils.map(studentService.findByStudentNumber(studentNumber), StudentInfoDTO.class);
	}

	@GetMapping(value = "/byEmail/{email}")
	public StudentInfoDTO getStudentByEmail(@PathVariable("email") String email) {
		return Utils.map(studentService.findByEmail(email), StudentInfoDTO.class);
	}

	@GetMapping(value = "/orderByGpa")
	public List<StudentInfoDTO> findAllByOrderByGpaDesc() {
		return Utils.mapAll(studentService.findAllByOrderByGpaDesc(), StudentInfoDTO.class);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveOrUpdateStudent(@RequestBody StudentInfoDTO studentDTO) {
		StudentInfo info = Utils.map(studentDTO, StudentInfo.class);
		
		String validationMsg = GenericValidator.isValid(info.getEmail());
		if (validationMsg != null) {
			return new ResponseEntity<Object>(validationMsg , HttpStatus.OK);	
		} else {
			studentService.saveOrUpdateStudent(info);
			return new ResponseEntity<Object>(GenericConstants.STUDENT_RECORD_SAVED, HttpStatus.OK);
		}
		
	}


	@DeleteMapping(value = "/delete/{studentNumber}")
	public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable long studentNumber) {
		studentService.deleteStudentById(studentService.findByStudentNumber(studentNumber).getId());
		return new ResponseEntity<Object>("Student deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateStudentNumber/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>updateStudentNumber(@PathVariable(value = "id") String id,
                                                         @RequestBody StudentInfoDTO studentDTO){
		StudentInfo info = Utils.map(studentDTO, StudentInfo.class);
        return new ResponseEntity<>(studentService.updateStudentNumber(id, info), HttpStatus.OK);
    }
}
