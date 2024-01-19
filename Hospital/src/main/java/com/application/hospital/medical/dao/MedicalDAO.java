package com.application.hospital.medical.dao;

import com.application.hospital.medical.dto.MedicalDTO;

public interface MedicalDAO {
	
	public String duplicatedId(String medicalId) throws Exception;
	public String duplicatedEmail(String medicalEmail) throws Exception;
	public String checkDuplicatedId(String medicalCode) throws Exception;
	public String duplicatedCode(String medicalCode) throws Exception;
	public void insertMedicalInfo(MedicalDTO medicalDTO) throws Exception;
}
