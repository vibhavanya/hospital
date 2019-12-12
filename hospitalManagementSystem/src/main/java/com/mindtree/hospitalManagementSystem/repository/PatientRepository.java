package com.mindtree.hospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.hospitalManagementSystem.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	boolean existspatientName(String patientName);

}
