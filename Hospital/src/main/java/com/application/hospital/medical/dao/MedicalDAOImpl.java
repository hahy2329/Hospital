package com.application.hospital.medical.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MedicalDAOImpl implements MedicalDAO {
	
	
	private final SqlSession sqlSession;
	
	@Override
	public String duplicatedId(String medicalId) throws Exception {
		return sqlSession.selectOne("medical.duplicatedId", medicalId);
	}

}
