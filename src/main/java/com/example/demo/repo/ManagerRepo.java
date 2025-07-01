package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ManagerEntity;

public interface ManagerRepo extends JpaRepository<ManagerEntity, Long> {
 
	public List<ManagerEntity> findByName(String name);
}
