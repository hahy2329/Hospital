package com.application.hospital.common.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.common.dto.ComplimentBoardDTO;
import com.application.hospital.common.service.CommonService;
import com.application.hospital.medical.dto.MedicalDTO;
import com.application.hospital.medical.service.MedicalService;
import com.application.hospital.patient.dto.PatientDTO;
import com.application.hospital.patient.service.PatientService;



import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommonController {
	
	private final PatientService patientService;
	private final MedicalService medicalService;
	private final CommonService commonService;
	
	@RequestMapping("/login")
	public ModelAndView login() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/common/login");
		
		return mv;
		
	}
	
	
	@RequestMapping("/loginSuccess")
	public ResponseEntity<Object> login(HttpServletRequest request, CommonLoginDTO commonLoginDTO) throws Exception{
		
		
		
		String message = "";
		
		HttpSession httpSession = request.getSession();
		
		HttpHeaders responHeaders = new HttpHeaders();
		responHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		
		if(patientService.getLoginInfo(commonLoginDTO) != null) {
			
			PatientDTO patientDTO = patientService.getLoginInfo(commonLoginDTO);
			
			httpSession.setAttribute("patientName", patientDTO.getPatientName());
			httpSession.setAttribute("patientId", patientDTO.getPatientId());
			httpSession.setMaxInactiveInterval(3600);
			
			message +="<script>";
			message += "alert('정상적으로 로그인 되었습니다.');";
			message +="location.href='" + request.getContextPath() +"/';";
			message +="</script>";
			
			return new ResponseEntity<Object>(message, responHeaders, HttpStatus.OK);
			
		}
		
		else if(medicalService.getLoginInfo(commonLoginDTO) != null) {
			
			MedicalDTO medicalDTO = medicalService.getLoginInfo(commonLoginDTO);
			
			httpSession.setAttribute("medicalName", medicalDTO.getMedicalName());
			httpSession.setAttribute("medicalId", medicalDTO.getMedicalId());
			httpSession.setMaxInactiveInterval(3600);
			
			message += "<script>";
			message += "alert('정상적으로 로그인 되었습니다.');";
			message +="location.href='" + request.getContextPath() +"/';";
			message +="</script>";
			
			return new ResponseEntity<Object>(message, responHeaders,HttpStatus.OK);
		}
		
		else {
			message +="<script>";
			message +="alert('ID 혹은 패스워드 재확인!');";
			message += "history.go(-1)";
			message +="</script>";
			
			return new ResponseEntity<Object>(message, responHeaders, HttpStatus.OK);
		}
	}
	
	@GetMapping("/introduce")
	public ModelAndView introduce() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/common/introduce");
		return mv;
	}
	
	@GetMapping("/complimentBoard")
	public ModelAndView complimentBoard(HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/common/complimentBoard");
		
		String searchKeyword = request.getParameter("searchKeyword");
		if(searchKeyword == null) searchKeyword = "total";
		
		String searchWord = request.getParameter("searchWord");
		if(searchWord == null) searchWord = "";
		
		int onePageViewCnt = 10;
		
		if(request.getParameter("onePageViewCnt") != null) {
			onePageViewCnt = Integer.parseInt(request.getParameter("onePageViewCnt"));
		}
		
		String temp = request.getParameter("currentPageNumber");
		if(temp == null) {
			temp = "1";
		}
		
		int currentPageNumber = Integer.parseInt(temp);
		
		Map<String, String> searchCntMap = new HashMap<String, String>();
		searchCntMap.put("searchKeyword", searchKeyword);
		searchCntMap.put("searchWord", searchWord);
		
		int allBoardCnt = commonService.getAllComplimentBoardCnt(searchCntMap);
		
		int allPageCnt = allBoardCnt / onePageViewCnt +1;
		
		if(allBoardCnt % onePageViewCnt == 0) allPageCnt--;
		
		int startPage = (currentPageNumber - 1) / 10 * 10 + 1;
		
		if(startPage == 0) {
			startPage = 1;
		}
		
		int endPage = startPage + 9;
		
		if(endPage > allPageCnt) endPage = allPageCnt;
		
		int startBoardIdx = (currentPageNumber - 1) * onePageViewCnt;
		
		mv.addObject("startPage", startPage); //스타트 페이지
		mv.addObject("endPage", endPage); //끝 페이지
		mv.addObject("allBoardCnt", allBoardCnt); // 전체 검색 결과 갯수 
		mv.addObject("allPageCnt", allPageCnt); // 전체 페이지 수 
		mv.addObject("onePageViewCnt", onePageViewCnt); //한 페이지에 보여질 갯수 
		mv.addObject("currentPageNumber", currentPageNumber); //현재 페이지  
		mv.addObject("startBoardIdx", startBoardIdx); //각 게시글에 주어지는 일련번호
		mv.addObject("searchKeyword", searchKeyword); //검색 범위
		mv.addObject("searchWord",searchWord); // 검색 키워드
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("onePageViewCnt", onePageViewCnt);
		searchMap.put("startBoardIdx", startBoardIdx);
		searchMap.put("searchKeyword", searchKeyword);
		searchMap.put("searchWord", searchWord);
		mv.addObject("complimentBoardList", commonService.getComplimentBoardList(searchMap));
		
		return mv;
		
	}
	
	@GetMapping("/complimentAddBoard")
	public ModelAndView complimentAddBoard() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/common/complimentAddBoard");
		
		return mv;
	}
	
	@GetMapping("/checkLoginInfo")
	public ResponseEntity<String> checkLoginInfo(HttpServletRequest request) throws Exception{
		
		CommonLoginDTO commonLoginDTO = new CommonLoginDTO();
		commonLoginDTO.setLoginId(request.getParameter("loginId"));
		commonLoginDTO.setLoginPassword(request.getParameter("loginPassword"));
		
		return new ResponseEntity<String>(commonService.checkLoginInfo(commonLoginDTO), HttpStatus.OK);
		
	}
	
	@PostMapping("/complimentAddBoard")
	public ResponseEntity<Object> complimentAddBoard(HttpServletRequest request) throws Exception{
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		ComplimentBoardDTO complimentBoardDTO = new ComplimentBoardDTO();
		complimentBoardDTO.setPatientId(request.getParameter("loginId"));
		complimentBoardDTO.setComplimentBoardSubject(request.getParameter("complimentBoardSubject"));
		complimentBoardDTO.setComplimentBoardContent(request.getParameter("complimentBoardContent"));
		
		
		commonService.complimentAddBoard(complimentBoardDTO);
		
		String message = "<script>";
		message +="alert('등록이 완료되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/';";
		message +="</script>";
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/complimentBoardDetail")
	public ModelAndView complimentBoardDetail(@RequestParam("complimentBoardId") long complimentBoardId) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		ComplimentBoardDTO complimentBoardDTO = commonService.getComplimentBoardDTO(complimentBoardId);
		mv.addObject("complimentBoardDTO", complimentBoardDTO);
		mv.setViewName("/common/complimentBoardDetail");
		
		return mv;
		
	}
	
}
