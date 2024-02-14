package com.application.hospital.common.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.application.hospital.common.dao.CommonDAO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final CommonDAO commonDAO;
	private final BCryptPasswordEncoder bcryPasswordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails user = null;
		
		try {
			user = (CustomUserDetails)commonDAO.getLoginInfo(username);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if(user != null) {
			return user;
		}else {
			return null;
		}
	}
	
	public boolean matchPasswordEncoder(String id, String password) throws Exception{
		
		boolean ready = false;
		
		if(bcryPasswordEncoder.matches(password, commonDAO.getBcryptPasswordEncoder(id))) {
			ready  = true;
			
			return ready;
		}else {
			return ready;
		}
	}

}
