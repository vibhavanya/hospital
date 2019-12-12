package com.mindtree.hospitalManagementSystem.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DoctorDto {
	@NotNull
	private String doctorId;
	private String doctorName;
	private int yearOfExperience;
	private int salary;
	@JsonIgnoreProperties("doctors")
	Set<PatientDto> patients;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public DoctorDto() {
		super();
	}

	public DoctorDto(String doctorId, String doctorName, int yearOfExperience, int salary, Set<PatientDto> patients) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.yearOfExperience = yearOfExperience;
		this.salary = salary;
		this.patients = patients;
	}

	public DoctorDto(String doctorId, String doctorName, int yearOfExperience, Set<PatientDto> patients) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.yearOfExperience = yearOfExperience;
		this.patients = patients;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public Set<PatientDto> getPatients() {
		return patients;
	}

	public void setPatients(Set<PatientDto> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "DoctorDto [doctorId=" + doctorId + ", doctorName=" + doctorName + ", yearOfExperience="
				+ yearOfExperience + ", patients=" + patients + "]";
	}

}
