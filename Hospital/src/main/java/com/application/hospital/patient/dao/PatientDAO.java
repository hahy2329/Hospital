package com.application.hospital.patient.dao;

public interface PatientDAO {
	
	public String getDuplicatedId(String patientId) throws Exception;
	public String getDuplicatedEmail(String patientEmail) throws Exception;
}
