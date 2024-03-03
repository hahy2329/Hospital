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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.application.hospital.common.dao.CommonDAO;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@NoArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	private CommonService commonService;
	private CommonDAO commonDAO;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		
		System.out.println(userName);
		
		if(userName.equals("")) {
			return null;
		}
		
		CustomUserDetails user = null;
		try {
			user = commonService.loadByUserName(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user.getUsername()!= null) {
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new SimpleGrantedAuthority(user.getAuthority()));
			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), roles);
			result.setDetails(user);
			return result;
		}else {
			return null;
		}
		
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	public boolean matchPasswordEncoder(String id, String password) throws Exception{
		
		boolean ready = false;
		
		if(bcryptPasswordEncoder.matches(password, commonDAO.getBcryptPasswordEncoder(id))) {
			ready  = true;
			
			return ready;
		}else {
			return ready;
		}
	}
	
}
