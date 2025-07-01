package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
	public List<StudentEntity> findByName(String name);
	
	public List<StudentEntity> findByNameAndUserName(String name , String userName);
}
