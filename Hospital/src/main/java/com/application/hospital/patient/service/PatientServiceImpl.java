package com.application.hospital.patient.service;

import org.springframework.stereotype.Service;

import com.application.hospital.patient.dao.PatientDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class PatientServiceImpl implements PatientService {

	private final PatientDAO patientDAO;
	
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

}
