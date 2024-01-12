package com.application.hospital.patient.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
