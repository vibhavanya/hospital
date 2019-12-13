package com.mindtree.hospitalManagementSystem.service;

import java.util.List;

import com.mindtree.hospitalManagementSystem.dto.DoctorDto;
import com.mindtree.hospitalManagementSystem.dto.PatientDto;
import com.mindtree.hospitalManagementSystem.exception.PatientNotFoundException;
import com.mindtree.hospitalManagementSystem.exception.ServiceException;

public interface DoctorService {

	/**
	 * @param doctorName
	 * @param patientName
	 * @return 
	 * @throws ServiceException 
	 * @throws PatientNotFoundException 
	 */
	PatientDto assignDoctorToPatient(String doctorName, String patientName) throws ServiceException;

	List<DoctorDto> sortOnSalary();
	
	List<DoctorDto> sortOnExperience();

	List<DoctorDto> putInFile();
	
}
