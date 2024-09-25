package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentPostRequestModel;
import com.example.demo.model.StudentPostResponseModel;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/test")
	public String test() {
		return "Test API works";
	}
	
	@PostMapping("/create")
	public StudentPostResponseModel create(@RequestBody StudentPostRequestModel request) {
		return studentService.create(request);
	}
	
	@PutMapping("/update/{id}")
	public StudentPostResponseModel update(@PathVariable int id ,@RequestBody StudentPostRequestModel request) {
		return studentService.update(id,request);
	}
	
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable int id) {
		
		return studentService.getStudent(id);
	}
	
	@GetMapping("/get")
	public ArrayList<Student> getStudents() {
		
		return studentService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public Student deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	/*
	 * Add the following functionalities:
	 * 1. Get All Employees
	 * 2. Delete an Employee on the basis of ID
	 * 3. Update an Employee on the basis of ID
	 * 4. Get Employee on the basis of Name
	 */
	
}
