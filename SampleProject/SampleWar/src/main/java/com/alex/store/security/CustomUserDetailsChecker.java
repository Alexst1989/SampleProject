package com.alex.store.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

public class CustomUserDetailsChecker implements UserDetailsChecker {

	private static final Logger LOGGER = LogManager.getLogger(CustomUserDetailsChecker .class);	
	
	@Override
	public void check(UserDetails toCheck) {
		if (toCheck == null) {
			throw new BadUserDetails("UserDetails are null");
		}
	}

}
