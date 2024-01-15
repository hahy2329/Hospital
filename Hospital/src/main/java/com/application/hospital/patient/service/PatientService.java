package com.application.hospital.patient.service;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.patient.dto.PatientDTO;

public interface PatientService {
	public String duplicatedId(String patientId) throws Exception;
	public String duplicatedEmail(String patientEmail) throws Exception;
	public void isertPatientInfo(PatientDTO patientDTO) throws Exception;
	public PatientDTO getLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception;
}
