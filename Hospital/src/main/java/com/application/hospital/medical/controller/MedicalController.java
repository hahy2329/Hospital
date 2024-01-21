package com.application.hospital.medical.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.hospital.medical.dto.MedicalDTO;
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
		
		return new ResponseEntity<String>(medicalService.duplicatedCode(medicalCode), HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(HttpServletRequest request) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = sdf.parse(request.getParameter("medicalBirth"));
		
		MedicalDTO medicalDTO = new MedicalDTO();
		medicalDTO.setMedicalId(request.getParameter("medicalId"));
		medicalDTO.setMedicalPw(request.getParameter("medicalPw"));
		medicalDTO.setMedicalName(request.getParameter("medicalName"));
		medicalDTO.setMedicalBirth(birth);
		medicalDTO.setMedicalEmail(request.getParameter("medicalEmail"));
		medicalDTO.setMedicalZipcode(request.getParameter("medicalZipcode"));
		medicalDTO.setMedicalRoadAddress(request.getParameter("medicalRoadAddress"));
		medicalDTO.setMedicalJibunAddress(request.getParameter("medicalJibunAddress"));
		medicalDTO.setMedicalNamujiAddress(request.getParameter("medicalNamujiAddress"));
		medicalDTO.setMedicalCode(request.getParameter("medicalCode"));
		
		medicalService.insertMedicalInfo(medicalDTO);
		
		String message = "<script>";
		message += "alert('회원가입 완료!');";
		message +="location.href='" + request.getContextPath() +"/';";
		message +="</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<Object> logout(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		String message = "<script>";
		message +="alert('정상적으로 로그아웃 되었습니다.');";
		message +="location.href='" + request.getContextPath() +"/';";
		message +="</script>";
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	
	
}
