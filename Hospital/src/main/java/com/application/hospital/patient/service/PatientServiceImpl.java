package com.application.hospital.patient.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.hospital.common.dto.CommonLoginDTO;
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
			
			return "notDuplicate";
			
		}else {
			return "duplicate";
		}
	}

	@Override
	public String duplicatedEmail(String patientEmail) throws Exception {
		if(patientDAO.getDuplicatedEmail(patientEmail) == null) {
			return "duplicateEmail";
		}else {
			return "notDuplicatedEmail";
		}
	}

	@Override
	public void isertPatientInfo(PatientDTO patientDTO) throws Exception {
		patientDTO.setPatientPw(bcryptPasswordEncoder.encode(patientDTO.getPatientPw()));
		
		patientDAO.insertPatientInfo(patientDTO);
		
	}

	@Override
	public PatientDTO getLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception {
		
		if(bcryptPasswordEncoder.matches(commonLoginDTO.getLoginPassword(), patientDAO.getEncodedPassword(commonLoginDTO.getLoginId()))) {
			
			return patientDAO.getLoginInfo(commonLoginDTO);
			
		}else {
			return null;
		}
	}

}
