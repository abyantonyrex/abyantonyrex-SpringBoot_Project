package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repo.StudentRepo;
@Service
public class StudentService {

	@Autowired
	public StudentRepo stuRepo;
	
	public List<StudentEntity> findAlluser() {
		return stuRepo.findAll();
	}
	
	public StudentEntity saveData(StudentEntity data) {
		return stuRepo.save(data);
	}
	
	public List<StudentEntity> saveMultipleData(List<StudentEntity> data) {
		return stuRepo.saveAll(data);
	}
	
	public StudentEntity findUsingId(Long id) {
		 StudentEntity orElse = stuRepo.findById(id).orElse(null);
		 return orElse;
	}
	
	public List<StudentEntity> checkName(String name){
		return stuRepo.findByName(name);
	}
	
	public List<StudentEntity> findByName(String name) {
		List<StudentEntity> byName = stuRepo.findByName(name);
		if(byName.isEmpty()) {
			return null;
		}
		else {
			return byName;
		}
	}
	
	public List<StudentEntity> findByNameAnduserName(String name , String userName){
		return stuRepo.findByNameAndUserName(name, userName);
	}
	
	public StudentEntity AddSingleUser(StudentEntity stu) {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StudentEntity saveData = this.saveData(stu);
		return saveData;
	}
	
	public boolean fileNotFound(Long id) {
		boolean existsById = stuRepo.existsById(id);
		return existsById;
	}
	
}
