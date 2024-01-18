package com.application.hospital.medical.service;

import org.springframework.stereotype.Service;

import com.application.hospital.medical.dao.MedicalDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalServiceImpl implements MedicalService {
	
	private final MedicalDAO medicalDAO;

	@Override
	public String duplicatedId(String medicalId) throws Exception {
		
		if(medicalDAO.duplicatedId(medicalId) == null) {
			return "duplicate";
		}else {
			return "notDuplicate";
		}	
	}
	
	
	
	
	
}
