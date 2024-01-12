package com.application.hospital.patient.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.application.hospital.patient.dto.PatientDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PatientDAOImpl implements PatientDAO {
	
	private final SqlSession sqlSession;
	
	@Override
	public String getDuplicatedId(String patientId) throws Exception {
		return sqlSession.selectOne("patient.duplicatedId", patientId);
	}

	@Override
	public String getDuplicatedEmail(String patientEmail) throws Exception {
		return sqlSession.selectOne("patient.duplicatedEmail", patientEmail);
	}

	@Override
	public void insertPatientInfo(PatientDTO patientDTO) throws Exception {
		sqlSession.insert("patient.insertPatientInfo", patientDTO);
		
	}

}
