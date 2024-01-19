package com.application.hospital.medical.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.hospital.medical.service.MedicalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/medical")
public class MedicalController {
	
	private final MedicalService medicalService;
	
	
	@GetMapping("/register")
	public ModelAndView register() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/medical/register");
		
		return mv;
	}
	
	@GetMapping("/checkDuplicatedId")
	public ResponseEntity<String> checkDuplicatedId(String medicalId) throws Exception{
		
		return new ResponseEntity<String>(medicalService.duplicatedId(medicalId), HttpStatus.OK);
		
	}
	
	@GetMapping("/checkDuplicatedEmail")
	public ResponseEntity<String> checkDuplicatedEmail(String medicalEmail) throws Exception{
		
		return new ResponseEntity<String>(medicalService.duplicatedEmail(medicalEmail), HttpStatus.OK);
		
	}
	
	@GetMapping("/checkDuplicatedCode")
	public ResponseEntity<String> checkDuplicatedCode(String medicalCode) throws Exception{
		
		
		
	}
	
	
}
