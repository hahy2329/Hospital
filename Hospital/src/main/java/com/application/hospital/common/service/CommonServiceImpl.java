package com.application.hospital.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.hospital.common.dao.CommonDAO;
import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.common.dto.ComplimentBoardDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

	private final CommonDAO commonDAO;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	@Override
	public int getAllComplimentBoardCnt(Map<String, String> searchCntMap) throws Exception {
		return commonDAO.getAllComplimentBoardCnt(searchCntMap);
	}

	@Override
	public List<ComplimentBoardDTO> getComplimentBoardList(Map<String, Object> searchMap) throws Exception {
		return commonDAO.getComplimentBoardList(searchMap);
	}

	@Override
	public String checkLoginInfo(CommonLoginDTO commonLoginDTO) throws Exception {
		
		if(bcryptPasswordEncoder.matches(commonLoginDTO.getLoginPassword(), commonDAO.getBcryptPasswordEncoder(commonLoginDTO.getLoginId()))) {
			return "successLoginInfo";
		}else {
			return "failLoginInfo";
		}
		
	}

	@Override
	public void complimentAddBoard(ComplimentBoardDTO complimentBoardDTO) throws Exception {
		commonDAO.complimentAddBoard(complimentBoardDTO);
	}

	@Override
	public ComplimentBoardDTO getComplimentBoardDTO(long complimentBoardId) throws Exception {
		commonDAO.increaseReadCnt(complimentBoardId);
		
		return commonDAO.getComplimentBoardDTO(complimentBoardId);
	}

	@Override
	public CustomUserDetails loadByUserName(String username) throws Exception {
		return commonDAO.loadByUserName(username);
	}

}
