package com.application.hospital.patient.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
	private String patientId;
	private String patientPw;
	private String patientName;
	private Date patientBirth;
	private String patientEmail;
	private String patientZipcode;
	private String patientRoadAddress;
	private String patientJibunAddress;
	private String patientNamujiAddress;
	private Date patientJoindt;
}
