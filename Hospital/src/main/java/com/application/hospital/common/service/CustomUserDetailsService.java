package com.application.hospital.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.hospital.common.dao.CommonDAO;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@NoArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CommonDAO commonDAO;
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		CustomUserDetails user = null;
		
		try {
			
			user = (CustomUserDetails)commonDAO.getLoginInfo(username);
			
			//여기다 bcryptPasswordEncoder 매칭
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user == null) {
			
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
