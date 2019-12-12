package com.mindtree.hospitalManagementSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.hospitalManagementSystem.dto.DoctorDto;
import com.mindtree.hospitalManagementSystem.dto.PatientDto;
import com.mindtree.hospitalManagementSystem.exception.AppException;
import com.mindtree.hospitalManagementSystem.exception.ServiceException;
import com.mindtree.hospitalManagementSystem.service.DoctorService;
import com.mindtree.hospitalManagementSystem.service.PatientService;

@RestController
public class HospitalController {
	@Autowired
	private PatientService patientService;

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/insert/{doctorName}/{patientName}")
	public ResponseEntity<PatientDto> saveDoctorWithPatient(@Valid @PathVariable String doctorName, @PathVariable String patientName) throws AppException {
		try {
			PatientDto patientDto=doctorService.assignDoctorToPatient(doctorName, patientName);
			return new ResponseEntity<PatientDto>(patientDto,HttpStatus.OK);
		} catch (ServiceException e) {
			throw new AppException(e.getMessage());
		}
	}
	
	@GetMapping("/getDoctorsBySal")
	public List<DoctorDto> getDoctorBySal() {
		return doctorService.sortOnSalary();
	}
	
	@GetMapping("/getDoctorsByExp")
	public List<DoctorDto> getDoctorByExp() {
		return doctorService.sortOnExperience();
	}
	
	
}
