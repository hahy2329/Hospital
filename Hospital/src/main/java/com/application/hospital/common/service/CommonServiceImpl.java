package com.application.hospital.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.application.hospital.common.dao.CommonDAO;
import com.application.hospital.common.dto.ComplimentBoardDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

	private final CommonDAO commonDAO;
	
	@Override
	public int getAllComplimentBoardCnt(Map<String, String> searchCntMap) throws Exception {
		return commonDAO.getAllComplimentBoardCnt(searchCntMap);
	}

	@Override
	public List<ComplimentBoardDTO> getComplimentBoardList(Map<String, Object> searchMap) throws Exception {
		return commonDAO.getComplimentBoardList(searchMap);
	}

}
