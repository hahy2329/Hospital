package com.application.hospital.patient.dao;

import com.application.hospital.patient.dto.PatientDTO;

public interface PatientDAO {
	
	public String getDuplicatedId(String patientId) throws Exception;
	public String getDuplicatedEmail(String patientEmail) throws Exception;
	public void insertPatientInfo(PatientDTO patientDTO) throws Exception;
}
