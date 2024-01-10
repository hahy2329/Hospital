package com.application.hospital.patient.dto;

import java.util.Date;

import lombok.Data;

@Data
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
