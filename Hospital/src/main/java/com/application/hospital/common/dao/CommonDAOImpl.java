package com.application.hospital.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.application.hospital.common.dto.ComplimentBoardDTO;
import com.application.hospital.common.service.CustomUserDetails;

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
		return sqlSession.selectOne("user.getBcryptPasswordEncoder", loginId);
	}

	@Override
	public void complimentAddBoard(ComplimentBoardDTO complimentBoardDTO) throws Exception {
		sqlSession.insert("complimentBoard.complimentAddBoard", complimentBoardDTO);
		
	}

	@Override
	public void increaseReadCnt(long complimentBoardId) throws Exception {
		sqlSession.update("complimentBoard.increaseReadCnt", complimentBoardId);
		
	}

	@Override
	public ComplimentBoardDTO getComplimentBoardDTO(long complimentBoardId) throws Exception {
		return sqlSession.selectOne("complimentBoard.getComplimentBoardDTO", complimentBoardId);
	}

	@Override
	public CustomUserDetails getLoginInfo(String username) throws Exception {
		return sqlSession.selectOne("user.getLoginInfo", username);
	}

	@Override
	public CustomUserDetails loadByUserName(String username) throws Exception {
		return sqlSession.selectOne("user.loadByUserName", username);
	}


}
