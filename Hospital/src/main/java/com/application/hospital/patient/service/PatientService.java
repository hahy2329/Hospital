package com.application.hospital.patient.service;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.common.service.CustomUserDetails;
import com.application.hospital.patient.dto.PatientDTO;

public interface PatientService {
	public String duplicatedId(String id) throws Exception;
	public String duplicatedIds(String id) throws Exception;
	public String duplicatedEmail(String patientEmail) throws Exception;
	public void isertPatientInfo(CustomUserDetails customUserDetails) throws Exception;
	public PatientDTO getLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception;
}
