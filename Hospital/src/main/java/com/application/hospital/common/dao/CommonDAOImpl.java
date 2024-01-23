package com.application.hospital.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.application.hospital.common.dto.ComplimentBoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CommonDAOImpl implements CommonDAO {
	
	private final SqlSession sqlSession;
	
	@Override
	public int getAllComplimentBoardCnt(Map<String, String> searchCntMap) throws Exception {
		return sqlSession.selectOne("complimentBoard.getAllComplimentBoardCnt", searchCntMap);
	}

	@Override
	public List<ComplimentBoardDTO> getComplimentBoardList(Map<String, Object> searchMap) throws Exception {
		return sqlSession.selectList("complimentBoard.getComplimentBoardList", searchMap);
	}

	@Override
	public String getBcryptPasswordEncoder(String loginId) throws Exception {
		return sqlSession.selectOne("patient.getBcryptPasswordEncoder", loginId);
	}

}
