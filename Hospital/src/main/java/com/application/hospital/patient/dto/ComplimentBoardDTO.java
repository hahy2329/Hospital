package com.application.hospital.patient.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ComplimentBoardDTO {
	
	private long complimentBoardId;
	private String complimentBoardSubject;
	private String complimentBoardContent;
	private int complimentBoardReadCnt;
	private Date complimentBoardEnrollDt;
	private String patientId;
	
}
