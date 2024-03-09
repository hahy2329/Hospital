package com.application.hospital.patient.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.hospital.common.service.CustomUserDetails;
import com.application.hospital.patient.dto.PatientDTO;
import com.application.hospital.patient.service.PatientService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {
	
	private final PatientService patientService;
	
	@GetMapping("/register")
	public ModelAndView register() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/patient/register");
		return mv;
	}
	
	@GetMapping("/checkDuplicatedIds")
	public ResponseEntity<String> checkDuplicatedIds(String userName) throws Exception{
		
		return new ResponseEntity<String>(patientService.duplicatedIds(userName), HttpStatus.OK);
	}
	
	
	@GetMapping("/checkDuplicatedId") //삭제 예정
	public ResponseEntity<String> checkDuplicatedId(String id) throws Exception{
	
		
		return new ResponseEntity<String>(patientService.duplicatedId(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/checkDuplicatedEmail")
	public ResponseEntity<String> checkDuplicatedEmail(String patientEmail) throws Exception{
		
		return new ResponseEntity<String>(patientService.duplicatedEmail(patientEmail), HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(HttpServletRequest request) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDt = sdf.parse(request.getParameter("birth"));
		
		CustomUserDetails customUserDetails = new CustomUserDetails();
		
		customUserDetails.setUserName(request.getParameter("userName"));
		customUserDetails.setPassword(request.getParameter("password"));
		customUserDetails.setName(request.getParameter("name"));
		customUserDetails.setBirth(birthDt);
		customUserDetails.setEmail(request.getParameter("email"));
		customUserDetails.setZipcode(request.getParameter("zipcode"));
		customUserDetails.setRoadAddress(request.getParameter("roadAddress"));
		customUserDetails.setJibunAddress(request.getParameter("jibunAddress"));
		customUserDetails.setNamujiAddress(request.getParameter("namujiAddress"));
		customUserDetails.setAuthority("ROLE_USER");
		
		
	
		
		patientService.isertPatientInfo(customUserDetails);
		
		String message = "<script>";
		message +="alert('회원가입 완료!');";
		message +="location.href='" + request.getContextPath() + "/login';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK); 
	}
	
	
	@GetMapping("/logout")
	public ResponseEntity<Object> logout(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		HttpHeaders responHeaders = new HttpHeaders();
		responHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		String message = "<script>";
		message +="alert('정상적으로 로그아웃 되었습니다.');";
		message +="location.href='" + request.getContextPath() + "/';";
		message +="</script>";
		
		return new ResponseEntity<Object>(message, responHeaders, HttpStatus.OK);
	}
	
	
	
}
