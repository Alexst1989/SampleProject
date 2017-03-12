package com.alex.store.security;

import com.alex.store.rest.RequestBody;

public class Credentials extends RequestBody {

	private static final long serialVersionUID = -467392416512003616L;

	private String userName;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
