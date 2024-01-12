package com.application.hospital.patient.service;

public interface PatientService {
	public String duplicatedId(String patientId) throws Exception;
	public String duplicatedEmail(String patientEmail) throws Exception;
}
