package com.application.hospital.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.application.hospital.common.dao.CommonDAO;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	private CommonDAO commonDAO;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		
		if(id.equals("")) {
			return null;
		}
		
		CustomUserDetails user = (CustomUserDetails)userDetailsService.loadUserByUsername(id);
		System.out.println(user.getId());
		
		
		if(user.getId()!= null) {
			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(id, password, user.getAuthorities());
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
