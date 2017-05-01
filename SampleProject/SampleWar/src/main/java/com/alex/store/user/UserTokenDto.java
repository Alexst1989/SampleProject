package com.alex.store.user;

import com.alex.store.vo.UserNameData;

/**
 * Class which contains all info that must be included in JWT.
 * 
 * @author alexp
 */
public class UserTokenDto {

	private Integer userId;

	private String login;

	private UserNameData userNameData;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
