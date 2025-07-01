package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StaffInformation;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repo.StaffRepo;

@Service
public class StaffService {
    
	@Autowired
	public StaffRepo staff;
	
	public List<StaffInformation> findAlluser() {
		return staff.findAll();
	}
	
	
	
	
	
}
