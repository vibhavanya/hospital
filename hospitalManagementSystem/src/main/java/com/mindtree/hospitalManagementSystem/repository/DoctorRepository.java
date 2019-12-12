package com.mindtree.hospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.hospitalManagementSystem.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	boolean existsBydoctorName(String doctorName);

}
