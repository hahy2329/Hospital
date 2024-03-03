package com.application.hospital.patient.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.common.service.CustomUserDetails;
import com.application.hospital.patient.dto.PatientDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PatientDAOImpl implements PatientDAO {
	
	private final SqlSession sqlSession;

	@Override
	public String duplicatedIds(String userName) throws Exception {
		return sqlSession.selectOne("patient.duplicatedIds", userName);
	}
	
	@Override
	public String getDuplicatedId(String id) throws Exception {
		return sqlSession.selectOne("patient.duplicatedId", id);
	}

	@Override
	public String getDuplicatedEmail(String patientEmail) throws Exception {
		return sqlSession.selectOne("patient.duplicatedEmail", patientEmail);
	}

	@Override
	public void insertPatientInfo(CustomUserDetails customUserDetails) throws Exception {
		sqlSession.insert("patient.insertPatientInfo", customUserDetails);
		
	}
	
	@Override
	public String getEncodedPassword(String loginId) throws Exception {
		return sqlSession.selectOne("patient.getEncodedPassword", loginId);
	}

	@Override
	public PatientDTO getLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception {
		return sqlSession.selectOne("patient.getLoginInfo", commonLoginDTO);
	}

	@Override
	public String getLoginIdInfo(String loginId) throws Exception {
		return sqlSession.selectOne("patient.getLoginIdInfo", loginId);
	}



}
