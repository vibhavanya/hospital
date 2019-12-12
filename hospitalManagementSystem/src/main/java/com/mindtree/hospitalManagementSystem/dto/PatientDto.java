package com.mindtree.hospitalManagementSystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PatientDto {

	private String patientId;
	private String patientName;
	private int billAmount;
	@JsonIgnoreProperties("patients")
	private DoctorDto doctors;

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

	public DoctorDto getDoctors() {
		return doctors;
	}

	public void setDoctors(DoctorDto doctors) {
		this.doctors = doctors;
	}

	public PatientDto() {
		super();
	}

	public PatientDto(String patientId, String patientName, int billAmount, DoctorDto doctors) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.billAmount = billAmount;
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "PatientDto [patientId=" + patientId + ", patientName=" + patientName + ", billAmount=" + billAmount
				+ ", doctors=" + doctors + "]";
	}

}
