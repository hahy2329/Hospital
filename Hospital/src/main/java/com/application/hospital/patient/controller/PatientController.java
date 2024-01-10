package com.application.hospital.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@GetMapping("/register")
	public ModelAndView register() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/patient/register");
		return mv;
	}
}
