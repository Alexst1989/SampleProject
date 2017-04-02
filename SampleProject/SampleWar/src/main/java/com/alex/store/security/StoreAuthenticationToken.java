package com.alex.store.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class StoreAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 3247069190132273559L;

	private Object principal;

	private Object credentials;
	
//	public StoreAuthenticationToken(UserTokenDto dto) {
//		this();
//		this.credentials = new Credentials();
//	}
	
	public StoreAuthenticationToken(UserDetails details, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.setDetails(details);
	}

	public StoreAuthenticationToken(UserDetails details)  {
		this(details, null);
	}

	public void setCredentials(Object credentials) {
		this.credentials = credentials;
	}
	
	@Override
	public Object getCredentials() {
		return credentials;
	}

	public void setPrincipal(Object principal) {
		this.principal = principal;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

}
