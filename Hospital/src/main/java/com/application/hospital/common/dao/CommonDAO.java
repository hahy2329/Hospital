package com.application.hospital.common.dao;

import java.util.List;
import java.util.Map;

import com.application.hospital.common.dto.ComplimentBoardDTO;
import com.application.hospital.common.service.CustomUserDetails;

public interface CommonDAO {
	
	public int getAllComplimentBoardCnt(Map<String, String> searchCntMap) throws Exception;
	public List<ComplimentBoardDTO> getComplimentBoardList(Map<String, Object> searchMap) throws Exception;
	public String getBcryptPasswordEncoder(String loginId) throws Exception;
	public void complimentAddBoard(ComplimentBoardDTO complimentBoardDTO) throws Exception;
	public void increaseReadCnt(long complimentBoardId) throws Exception;
	public ComplimentBoardDTO getComplimentBoardDTO(long complimentBoardId) throws Exception;
	public CustomUserDetails getLoginInfo(String username) throws Exception;
	public CustomUserDetails loadByUserName(String userName) throws Exception;

}
