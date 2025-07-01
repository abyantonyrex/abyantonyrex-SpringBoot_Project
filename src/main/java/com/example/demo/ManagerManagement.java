package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ManagerEntity;
import com.example.demo.service.ManagerService;

@RestController
@RequestMapping("/manager")
@CrossOrigin("http://localhost:3000")
public class ManagerManagement {
  
	@Autowired
	public ManagerService Manser;
	
	@PostMapping("/addSingleUser")
	public ManagerEntity addSingleUser(@RequestBody ManagerEntity  en) {
		return Manser.addSingleUser(en);
	}
	
	@GetMapping("/displayAllUser")
	public List<ManagerEntity> displayAll() {
		return Manser.displayAllUser();
	}
	
	@GetMapping("/getById/{id}")
	public ManagerEntity getById(@PathVariable("id") Long id) {
		return Manser.getById(id);
	}
	
	@PutMapping("/editById/{id}")
	public ManagerEntity editById(@PathVariable("id") Long id , @RequestBody ManagerEntity newData) {
		return Manser.edit(id, newData);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteTheUser(@PathVariable("id") Long id){
		 Manser.deleteUserById(id);
	}
	
	@GetMapping("/DisplayUser/{name}")
	public List<ManagerEntity> displayUserByName(@PathVariable("name") String name){
		return Manser.showUserByName(name);
	}
	
}
