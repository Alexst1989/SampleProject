package com.alex.store.rest.security.token;

import com.alex.store.rest.RequestBody;

public class Credentials extends RequestBody {
	
	private static final long serialVersionUID = 3638511604780451997L;

	private String login;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	

}
