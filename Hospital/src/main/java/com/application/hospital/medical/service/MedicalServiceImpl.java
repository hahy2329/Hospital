package com.application.hospital.medical.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.medical.dao.MedicalDAO;
import com.application.hospital.medical.dto.MedicalDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalServiceImpl implements MedicalService {
	
	private final MedicalDAO medicalDAO;
	
	private final BCryptPasswordEncoder bcryptPasswordEncoder;

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

	@Override
	public void insertMedicalInfo(MedicalDTO medicalDTO) throws Exception {
		
		medicalDTO.setMedicalPw(bcryptPasswordEncoder.encode(medicalDTO.getMedicalPw()));
		
		medicalDAO.insertMedicalInfo(medicalDTO);
		
		
	}

	@Override
	public MedicalDTO getLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception {
		
		if(medicalDAO.getLoginIdInfo(commonLoginDTO.getLoginId()) != null) {
			if(bcryptPasswordEncoder.matches(commonLoginDTO.getLoginPassword(), medicalDAO.getLoginIdInfo(commonLoginDTO.getLoginId()))) {
				
				return medicalDAO.getLoginInfo(commonLoginDTO);
			}else {
				
				return null;
			}
		}else {
			return null;
		}
		
	}
	
	
	
	
	
}
