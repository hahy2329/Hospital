package com.application.hospital.patient.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.common.service.CustomUserDetails;
import com.application.hospital.patient.dao.PatientDAO;
import com.application.hospital.patient.dto.PatientDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class PatientServiceImpl implements PatientService {

	private final PatientDAO patientDAO;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public String duplicatedId(String patientId) throws Exception {
		if(patientDAO.getDuplicatedId(patientId)!= null) {
			
			return "duplicate";
			
		}else {
			return "notDuplicate";
		}
	}

	@Override
	public String duplicatedEmail(String patientEmail) throws Exception {
		if(patientDAO.getDuplicatedEmail(patientEmail) == null) {
			return "notDuplicateEmail";
		}else {
			return "duplicateEmail";
		}
	}

	@Override
	public void isertPatientInfo(CustomUserDetails customUserDetails) throws Exception {
		customUserDetails.setPassword(bcryptPasswordEncoder.encode(customUserDetails.getPassword()));
		
		patientDAO.insertPatientInfo(customUserDetails);
		
	}

	@Override
	public PatientDTO getLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception {
		
		
		if(patientDAO.getLoginIdInfo(commonLoginDTO.getLoginId()) != null) {
			if(bcryptPasswordEncoder.matches(commonLoginDTO.getLoginPassword(), patientDAO.getEncodedPassword(commonLoginDTO.getLoginId()))) {
				
				return patientDAO.getLoginInfo(commonLoginDTO);		
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

}
