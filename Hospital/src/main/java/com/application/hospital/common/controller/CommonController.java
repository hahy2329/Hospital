package com.application.hospital.common.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

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
import com.application.hospital.medical.dto.MedicalDTO;
import com.application.hospital.medical.service.MedicalService;
import com.application.hospital.patient.dto.PatientDTO;
import com.application.hospital.patient.service.PatientService;



import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/common")
public class CommonController {
	
	private final PatientService patientService;
	private final MedicalService medicalService;
	
	@GetMapping("/login")
	public ModelAndView login() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/common/login");
		
		return mv;
		
	}
	
	
	@PostMapping("/login")
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
}
