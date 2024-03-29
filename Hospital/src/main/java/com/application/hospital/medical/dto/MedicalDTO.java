package com.application.hospital.medical.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class MedicalDTO {
	
	private String medicalId;
	private String medicalPw;
	private String medicalName;
	private Date medicalBirth;
	private String medicalEmail;
	private String medicalZipcode;
	private String medicalRoadAddress;
	private String medicalJibunAddress;
	private String medicalNamujiAddress;
	private Date medicalJoinDt;
	private String medicalCode;
	
	
}
