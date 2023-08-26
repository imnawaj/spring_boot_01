package com.rt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rt.dao.std_dao;
import com.rt.entity.StudentEntity;

@Component
public class std_service {
	
	@Autowired
	std_dao dao;

	public void addstd(StudentEntity s) {
		
		dao.save(s);
	}

	public StudentEntity singleyBId(int id) {
		StudentEntity s1 = null;
	Optional<StudentEntity> s=	dao.findById(id);
	
	if(s.isPresent()){
		s1= s.get();
		return s1;
	}
	return s1;
		
	}

	public StudentEntity deleteyBId(int id) {
		dao.deleteById(id);
		return null;
	}

	public List<StudentEntity> AllData() {
		List<StudentEntity> list = dao.findAll();
		return list;
	}

	public List<StudentEntity> stdByName(String name) {
		List<StudentEntity> list= dao.findByName(name);
		return list;
	}

	public List<StudentEntity> StudentByName(String name) {
		List<StudentEntity> list= dao.findByName(name);
		return list;
	}

}
