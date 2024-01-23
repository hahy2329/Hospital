package com.application.hospital.common.service;

import java.util.List;
import java.util.Map;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.common.dto.ComplimentBoardDTO;

public interface CommonService {
	
	public int getAllComplimentBoardCnt(Map<String, String> searchCntMap) throws Exception;
	public List<ComplimentBoardDTO> getComplimentBoardList(Map<String, Object> searchMap) throws Exception;
	public String checkLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception;
}
