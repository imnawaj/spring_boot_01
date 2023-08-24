package com.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rt.entity.StudentEntity;
import com.rt.service.std_service;

@RestController
public class Homecontroller {
	
	@Autowired
	std_service service;
	
	
	@RequestMapping("/hello")
	public String hello() {
		
		return" Hello Nawaj Wel-Come to Spring Boot";
	}
	
	@GetMapping("/student")
	public StudentEntity StudentRegister() {
		
		StudentEntity s = new StudentEntity(01,"Nawaj","Sangola");
		
		return s;
	}

	@PostMapping("/student/{id}/name/{name}")
	public StudentEntity StudentRegisterById(@PathVariable("id") int id,@PathVariable("name") String name) {
		
		StudentEntity s = new StudentEntity(id,"Hello "+""+name,"Sangola");
		
		return s;
	}
	
	@PostMapping("/studentdata")
	public String StudentAdd(@RequestBody StudentEntity s) {
		
		StudentEntity std = new StudentEntity(s.getId(),s.getName(),s.getAddress());
		
	
		System.out.println("id :"+ s.getId());
		System.out.println("Name :"+ s.getName());
		System.out.println("Address :"+ s.getAddress());
		System.out.println("Data Added Sucessfully");
		
		return "DATA ADDED SUCESSFULL";
	}
	
//	------------@RequestParam Annotation------------------------------------------------
	
	@PostMapping("/student/casit")
	public StudentEntity student(@RequestParam("id") int id,@RequestParam("name") String name) {
		
		StudentEntity s = new StudentEntity(id,"Hello "+""+name,"Sangola");
		
		return s;
	}
	
//	------------data addd  database------------------------------------------------
	
	@PostMapping("/add")
	public String AddData(@RequestBody StudentEntity s) {
		service.addstd(s);
		return"Data Added";
		
	}
	
	
//	------------data singlebyid ------------------------------------------------
	
	@GetMapping("std/id/{id}")
	public StudentEntity singleyBId(@PathVariable int id) {
	StudentEntity s=	service.singleyBId(id);
		return s;
		
	}
	
//	------------data deletebyid ------------------------------------------------
	
	@DeleteMapping("std/id/{id}")
	public String deleteyBId(@PathVariable int id) {
	StudentEntity s=	service.deleteyBId(id);
	System.out.println("deleted sucess full");
		return "Deleted Sucess Full";
		
	}

}
