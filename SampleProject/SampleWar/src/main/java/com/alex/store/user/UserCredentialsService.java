package com.alex.store.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialsService {
	
	@Autowired
	private UserDao userDao;
	
	public UserInfo checkLoginPassword(Credentials cred) {
		if (cred == null || cred.getLogin() == null) {
			throw new BadCredentialsException("Credentials or login is null");
		}
		
		UserInfo userInfo = userDao.getUserByLogin(cred.getLogin());
		
		if (userInfo == null) {
			throw new UserNotFoundException(String.format("User with login %s not found", cred.getLogin()));
		}
		
		if (!cred.getPassword().equals(userInfo.getPassword())) {
			throw new BadCredentialsException("Invalid password");
		}
		
		return userInfo;
	}

}
