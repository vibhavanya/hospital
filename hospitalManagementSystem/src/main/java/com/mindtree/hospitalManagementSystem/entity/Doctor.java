package com.mindtree.hospitalManagementSystem.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Doctor")
public class Doctor implements Comparable<Doctor> {

	@Id
	@Column(name = "Doctor_Id")
	private String doctorId;

	@Column(name = "Doctor_Name")
	private String doctorName;

	@Column(name = "Year_Of_Experience")
	private int yearOfExperience;

	@Column(name = "Salary")
	private int salary;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "doctors")
	Set<Patient> patients;

	public Doctor() {
		super();
	}

	public Doctor(String doctorId, String doctorName, int yearOfExperience, int salary, Set<Patient> patients) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.yearOfExperience = yearOfExperience;
		this.salary = salary;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", yearOfExperience=" + yearOfExperience
				+ ", salary=" + salary + ", patients=" + patients + "]";
	}

	@Override
	public int compareTo(Doctor arg0) {
		return this.getSalary() - arg0.getSalary();
	}

}
