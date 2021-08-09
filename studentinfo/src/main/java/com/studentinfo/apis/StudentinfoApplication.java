package com.studentinfo.apis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.studentinfo.respositories.StudentDOARepository;


@SpringBootApplication
@ComponentScan({"com.studentinfo.controllers","com.studentinfo.services", "com.studentinfo.respositories","com.studentinfo.dao","com.studentinfo.models",
		"com.studentinfo.utils", "com.studentinfo.constants","com.studentinfo.enums"})
@EnableMongoRepositories(basePackageClasses = StudentDOARepository.class)

public class StudentinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentinfoApplication.class, args);
	}

}