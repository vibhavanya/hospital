package com.mindtree.hospitalManagementSystem.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.hospitalManagementSystem.repository.DoctorRepository;
import com.mindtree.hospitalManagementSystem.repository.PatientRepository;
import com.mindtree.hospitalManagementSystem.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
}
