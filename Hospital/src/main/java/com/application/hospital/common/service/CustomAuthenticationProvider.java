package com.application.hospital.common.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final CustomUserDetailsService customUserDetailsService;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		try {
			if(customUserDetailsService.matchPasswordEncoder(id, password)) {
				CustomUserDetails user = (CustomUserDetails)customUserDetailsService.loadUserByUsername(id);
				
				UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user.getId(), user.getPassword(), user.getAuthorities());
				result.setDetails(user);
				
				return result;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
