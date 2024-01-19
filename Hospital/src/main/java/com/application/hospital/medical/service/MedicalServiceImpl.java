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
			return "notDuplicate";
		}else {
			return "duplicate";
		}	
	}

	@Override
	public String duplicatedEmail(String medicalEmail) throws Exception {
		
		if(medicalDAO.duplicatedEmail(medicalEmail) == null) {
			return "notDuplicateEmail";
		}else {
			return "duplicateEmail";
		}
	}

	@Override
	public String duplicatedCode(String medicalCode) throws Exception {
		
		if(medicalDAO.checkDuplicatedId(medicalCode) == null) {
			if(medicalDAO.duplicatedCode(medicalCode) != null) {
				
				return "checkOkCode";
			}else {
				
				return "notExist";
			}
		}else {
			
			return "beInUse";
		}
	}
	
	
	
	
	
}
