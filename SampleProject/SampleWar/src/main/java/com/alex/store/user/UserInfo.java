package com.alex.store.user;

import com.alex.store.vo.UserNameData;

public class UserInfo {
	
	private Integer id;
	
	private UserNameData userNameData;
	
	private String age;
	
	private String login;
	
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public UserNameData getUserNameData() {
		return userNameData;
	}

	public void setUserNameData(UserNameData userNameData) {
		this.userNameData = userNameData;
	}

	
}
