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
	private CustomUserDetails user;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("로그 확인");
		
		CustomUserDetails user = new CustomUserDetails();
		
		try {
			user = commonDAO.getLoginInfo(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
		
		
		
		
	}
	
	

}
