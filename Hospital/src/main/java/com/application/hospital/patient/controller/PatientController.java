package com.application.hospital.patient.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/checkDuplicatedId")
	public ResponseEntity<String> checkDuplicatedId(String patientId) throws Exception{
		return new ResponseEntity<String>(patientService.duplicatedId(patientId), HttpStatus.OK);
		
	}
	
	@GetMapping("/checkDuplicatedEmail")
	public ResponseEntity<String> checkDuplicatedEmail(String patientEmail) throws Exception{
		
		return new ResponseEntity<String>(patientService.duplicatedEmail(patientEmail), HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(HttpServletRequest request, @ModelAttribute PatientDTO patientDTO) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
		patientDTO.setPatientBirth(sdf.parse(request.getParameter("patientId")));
		
		patientService.isertPatientInfo(patientDTO);
		
		String message = "<script>";
		message +="alert('회원가입 완료!');";
		message +="location.href='" + request.getContextPath() + "/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK); 
	}
}
