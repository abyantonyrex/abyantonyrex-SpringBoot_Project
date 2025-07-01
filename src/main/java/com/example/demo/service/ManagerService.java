package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.ManagerEntity;
import com.example.demo.repo.ManagerRepo;

@Service
public class ManagerService {

	@Autowired
	public ManagerRepo ManRepo;
	
	public ManagerEntity addSingleUser(ManagerEntity m) {
		return ManRepo.save(m);
	}
	
	public List<ManagerEntity> displayAllUser( ) {
		return ManRepo.findAll();
	}
	
	public ManagerEntity getById(Long id) {
		return ManRepo.findById(id).orElse(null);
	}
	
	public ManagerEntity edit(Long id, ManagerEntity newData) {
		boolean existsById = ManRepo.existsById(id);
		ManagerEntity oldData = ManRepo.findById(id).get();
		if(existsById) {
			oldData.setName(newData.getName());
			oldData.setUserName(newData.getUserName());
			oldData.setPassword(newData.getPassword());
			oldData.setLocation(newData.getLocation());
			ManRepo.save(oldData);
			return oldData;
		}
		else {
			return oldData;
		}
	}
	
	public void deleteUserById(Long id){
		boolean existsById = ManRepo.existsById(id);
		if(existsById) {
			ManRepo.deleteById(id);
		}
	}
	
	public List<ManagerEntity> showUserByName(String name){
		return ManRepo.findByName(name);
	}
}
