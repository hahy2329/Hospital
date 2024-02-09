package com.application.hospital.patient.dao;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.common.service.CustomUserDetails;
import com.application.hospital.patient.dto.PatientDTO;

public interface PatientDAO {
	
	public String duplicatedIds(String id) throws Exception;
	public String getDuplicatedId(String id) throws Exception;
	public String getDuplicatedEmail(String patientEmail) throws Exception;
	public void insertPatientInfo(CustomUserDetails customUserDetails) throws Exception;
	public String getEncodedPassword(String loginId) throws Exception;
	public String getLoginIdInfo(String loginId) throws Exception;
	public PatientDTO getLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception;
	
}
