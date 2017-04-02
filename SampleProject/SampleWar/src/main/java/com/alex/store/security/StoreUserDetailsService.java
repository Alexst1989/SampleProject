package com.alex.store.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.alex.store.user.UserDao;

public class StoreUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LogManager.getLogger(StoreUserDetailsService.class);

	private UserDao userDao;

	private UserInfoConverter converter;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		if (login == null) {
			LOGGER.warn("login is null");
			return null;
		}
		return converter.getUserDetails(userDao.getUserByLogin(login));
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserInfoConverter getConverter() {
		return converter;
	}

	public void setConverter(UserInfoConverter converter) {
		this.converter = converter;
	}

}
