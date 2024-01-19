package com.application.hospital.medical.service;

public interface MedicalService {
	
	public String duplicatedId(String medicalId) throws Exception;
	public String duplicatedEmail(String medicalEmail) throws Exception;
	public String duplicatedCode(String medicalCode) throws Exception;
}
