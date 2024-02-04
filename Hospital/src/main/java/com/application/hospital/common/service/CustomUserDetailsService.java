package com.application.hospital.common.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.hospital.common.dao.CommonDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	
	private final CommonDAO commonDAO;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		CustomUserDetails user = null;
		
		try {
			user = (CustomUserDetails)commonDAO.getLoginInfo(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(username == null) {
			
			return null;
		}
		return user;
		
	}
	
	public boolean matchPasswordEncoder(String id, String password) throws Exception{
		boolean ready = false;
		
		if(bcryptPasswordEncoder.matches(password, commonDAO.getBcryptPasswordEncoder(id))) {
			ready = true;
			
			return ready;
		}else {
			return ready;
		}
		
	}

}
