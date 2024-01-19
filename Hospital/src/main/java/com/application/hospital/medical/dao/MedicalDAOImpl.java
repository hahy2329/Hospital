package com.application.hospital.medical.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.medical.dto.MedicalDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MedicalDAOImpl implements MedicalDAO {
	
	
	private final SqlSession sqlSession;
	
	@Override
	public String duplicatedId(String medicalId) throws Exception {
		return sqlSession.selectOne("medical.duplicatedId", medicalId);
	}

	@Override
	public String duplicatedEmail(String medicalEmail) throws Exception {
		return sqlSession.selectOne("medical.duplicatedEmail", medicalEmail);
	}

	@Override
	public String checkDuplicatedId(String medicalCode) throws Exception {
		return sqlSession.selectOne("medical.checkDuplicatedId", medicalCode);
	}

	@Override
	public String duplicatedCode(String medicalCode) throws Exception {
		return sqlSession.selectOne("medical.duplicatedCode", medicalCode);
	}

	@Override
	public void insertMedicalInfo(MedicalDTO medicalDTO) throws Exception {
		sqlSession.insert("medical.insertMedicalInfo", medicalDTO);
		
	}

	@Override
	public String getLoginIdInfo(String loginId) throws Exception {
		return sqlSession.selectOne("medical.getLoginIdInfo", loginId);
	}

	@Override
	public MedicalDTO getLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception {
		return sqlSession.selectOne("medical.getLoginInfo", commonLoginDTO);
	}

}
