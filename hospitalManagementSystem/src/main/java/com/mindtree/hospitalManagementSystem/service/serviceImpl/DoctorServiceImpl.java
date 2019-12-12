package com.mindtree.hospitalManagementSystem.service.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.hospitalManagementSystem.dto.DoctorDto;
import com.mindtree.hospitalManagementSystem.dto.PatientDto;
import com.mindtree.hospitalManagementSystem.entity.Doctor;
import com.mindtree.hospitalManagementSystem.entity.Patient;
import com.mindtree.hospitalManagementSystem.entity.YearCompare;
import com.mindtree.hospitalManagementSystem.exception.DoctorNotFoundException;
import com.mindtree.hospitalManagementSystem.exception.PatientNotFoundException;
import com.mindtree.hospitalManagementSystem.exception.ServiceException;
import com.mindtree.hospitalManagementSystem.repository.DoctorRepository;
import com.mindtree.hospitalManagementSystem.repository.PatientRepository;
import com.mindtree.hospitalManagementSystem.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	ModelMapper mapper = new ModelMapper();

	@Override
	public PatientDto assignDoctorToPatient(String doctorName, String patientName) throws ServiceException {
		List<Doctor> doctorList = doctorRepository.findAll();
		List<Patient> patientList = patientRepository.findAll();
		if (doctorRepository.existsBydoctorName(doctorName)) {
			if (patientRepository.existspatientName(patientName)) {
				Doctor doctor = new Doctor();
				Patient patient = new Patient();
				for (Doctor doctor1 : doctorList) {
					if (doctor1.getDoctorName().equals(doctorName)) {
						doctor = doctor1;
					}
				}
				for (Patient patient1 : patientList) {
					if (patient1.getPatientName().equals(patientName)) {
						patient = patient1;
					}
				}
				doctor.setSalary(doctor.getSalary() + patient.getBillAmount());
				patient.setDoctors(doctor);
				patientRepository.save(patient);
				PatientDto patientDto = convertIntoDto(patient);
				return patientDto;
			} else {
				try {
					throw new PatientNotFoundException("Pat not found");
				} catch (PatientNotFoundException e) {
					throw new ServiceException(e.getMessage());
				}
			}
		} else {
			try {
				throw new DoctorNotFoundException("Doc Not Found");
			} catch (DoctorNotFoundException e) {
				throw new ServiceException(e.getMessage());
			}
		}
	}

	private PatientDto convertIntoDto(Patient patient) {
		return mapper.map(patient, PatientDto.class);
	}

	@Override
	public List<DoctorDto> sortOnSalary() {
		List<Doctor> doctorlist = doctorRepository.findAll();
		Collections.sort(doctorlist);
		doctorRepository.saveAll(doctorlist);
		List<DoctorDto> doctorDtos = new ArrayList<>();
		for (Doctor doctor : doctorlist) {
			doctorDtos.add(convertIntoDto(doctor));
		}
		return doctorDtos;
	}

	private DoctorDto convertIntoDto(Doctor doctor) {
		return mapper.map(doctor, DoctorDto.class);
	}

	@Override
	public List<DoctorDto> sortOnExperience() {
		List<Doctor> doctors = new ArrayList<>();
		List<DoctorDto> doctorDtos = new ArrayList<>();
		List<Doctor> doctors2 = doctorRepository.findAll();
		for (Doctor doctor : doctors2) {
			Set<Patient> patients = doctor.getPatients();
			if (patients.size() > 3) {
				doctors.add(doctor);
				YearCompare yearCompare = new YearCompare();
				Collections.sort(doctors, yearCompare);
			}
		}
		for (Doctor doctor : doctors) {
			doctorDtos.add(convertIntoDto(doctor));
		}
		return doctorDtos;
	}

}