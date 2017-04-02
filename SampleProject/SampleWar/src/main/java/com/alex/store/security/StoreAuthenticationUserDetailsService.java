package com.alex.store.security;

import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.alex.store.user.StoreUserDetails;
import com.alex.store.user.UserDao;

public class StoreAuthenticationUserDetailsService implements AuthenticationUserDetailsService<StoreAuthenticationToken>{
	
	private UserDao userDao;
	private UserInfoConverter converter;
	
	public StoreAuthenticationUserDetailsService(UserDao userDao, UserInfoConverter converter) {
		this.userDao = userDao;
		this.converter = converter;
	}

	@Override
	public UserDetails loadUserDetails(StoreAuthenticationToken token) throws UsernameNotFoundException {
		if (token == null) {
			return null;
		}
		StoreUserDetails details = (StoreUserDetails) token.getDetails();
		return converter.getUserDetails(userDao.getUserById(details.getUserId()));
	}

}
