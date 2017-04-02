package com.alex.store.security;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationToken extends AuthenticationException {

	private static final long serialVersionUID = 8117331477663606589L;

	public InvalidJwtAuthenticationToken(String msg) {
		super(msg);
	}
	
	public InvalidJwtAuthenticationToken(String msg, Throwable ex) {
		super(msg, ex);
	}

}
