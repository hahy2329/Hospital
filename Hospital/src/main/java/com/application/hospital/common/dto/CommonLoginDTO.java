package com.application.hospital.common.dto;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class CommonLoginDTO{
	
	
	private String loginId;
	private String loginPassword;
	
	

}
