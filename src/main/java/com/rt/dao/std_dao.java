package com.rt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rt.entity.StudentEntity;
@Repository
public interface std_dao extends JpaRepository<StudentEntity,Integer>{
	
}