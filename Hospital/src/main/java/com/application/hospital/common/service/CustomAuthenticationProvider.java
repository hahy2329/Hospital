package com.application.hospital.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.application.hospital.common.dto.CommonLoginDTO;
import com.application.hospital.patient.dto.PatientDTO;
import com.application.hospital.patient.service.PatientService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



/*
 * 실질적으로 인증 절차가 이뤄지는 곳이다.
 * 서비스단으로부터 db에 저장된 사용자 정보와 비교 후 넘어온 리턴 객체를 가지고 
 * Authentication 객체를 생성하거나 인증되지 못하는 경우 예외를 넘겨주는 역할을 한다.
 * (해당 코딩에서는 DB를 따로 구현을 안했다.)
 * 
 * */

@NoArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String id = (String)authentication.getPrincipal(); //보호받는 Resource에 접근하는 대상 쉽게 말해, id
		String password = (String)authentication.getCredentials(); //Resource에 접근하는 대상의 비밀번호
		//form에서 전달 된, name태그 설정이 username-parameter, password-parameter로 되있는 값을 읽어온다.
		
		
		
		CustomUserDetails user = (CustomUserDetails)customUserDetailsService.loadUserByUsername(id);
	
		return new UsernamePasswordAuthenticationToken(id, password, user.getAuthorities());
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	
	
	
	
}
