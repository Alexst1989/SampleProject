package com.alex.store.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationManager implements AuthenticationManager {

	@Override
	public Authentication authenticate(Authentication paramAuthentication) throws AuthenticationException {
		paramAuthentication.setAuthenticated(true);
		
		return paramAuthentication;
	}

}
