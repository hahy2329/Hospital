package com.application.hospital.medical.dao;

public interface MedicalDAO {
	
	public String duplicatedId(String medicalId) throws Exception;
	public String duplicatedEmail(String medicalEmail) throws Exception;
}
