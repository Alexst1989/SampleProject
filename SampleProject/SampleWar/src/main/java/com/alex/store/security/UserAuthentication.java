package com.alex.store.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuthentication implements Authentication {
	
	private static final long serialVersionUID = -7831165009344555094L;
	
	private String name;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	private Credentials credentials;
	
	private UserDetails userDetails;
	
	private boolean isAuthenticated;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getDetails() {
		return userDetails;
	}

	@Override
	public Object getPrincipal() {
		return userDetails.getUsername();
	}

	@Override
	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	@Override
	public void setAuthenticated(boolean arg0) throws IllegalArgumentException {
		this.isAuthenticated = arg0;
	}

}
