package com.application.hospital.patient.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PatientDAOImpl implements PatientDAO {
	
	private final SqlSession sqlSession;
	
	@Override
	public String getDuplicatedId(String patientId) throws Exception {
		return sqlSession.selectOne("patient.duplicatedId", patientId);
	}

}
