package com.mindtree.hospitalManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@Column(name = "Patient_Id")
	private String patientId;

	@Column(name = "Patient_Name")
	private String patientName;

	@Column(name = "Bill_Amount")
	private int billAmount;

	@ManyToOne
	@JoinColumn(name = "Doctor_Id")
	private Doctor doctors;

	public Patient() {
		super();
	}

	public Patient(String patientId, String patientName, int billAmount, Doctor doctors) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.billAmount = billAmount;
		this.doctors = doctors;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public Doctor getDoctors() {
		return doctors;
	}

	public void setDoctors(Doctor doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", billAmount=" + billAmount
				+ ", doctors=" + doctors + "]";
	}

}
