package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StaffInformation;

public interface StaffRepo extends JpaRepository<StaffInformation, Long> {


}
