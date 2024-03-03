package com.practice.springboot3features.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot3features.dto.Student;



@RestController
@RequestMapping("/home")
public class MyController {
	
	@RequestMapping("/test")
	public ResponseEntity<Student> testing() {
		var newAddress="America";
		var student  = new Student(1,"Nick",newAddress);
		System.out.println("student: "+student);
		System.out.println("student data: "+student.id()+ "--"+student.name()+"--"+student.address());
		return new  ResponseEntity<Student>(student, HttpStatusCode.valueOf(200));
	}
}
