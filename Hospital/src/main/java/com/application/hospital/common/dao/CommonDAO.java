package com.application.hospital.common.dao;

import java.util.List;
import java.util.Map;

import com.application.hospital.common.dto.ComplimentBoardDTO;

public interface CommonDAO {
	
	public int getAllComplimentBoardCnt(Map<String, String> searchCntMap) throws Exception;
	public List<ComplimentBoardDTO> getComplimentBoardList(Map<String, Object> searchMap) throws Exception;
}
