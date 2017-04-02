package com.alex.store.user;

public interface UserDao {
	
	UserInfo getUserById(int id);
	
	UserInfo getUserByLogin(String Login);
	
	void addUser(UserInfo userInfo);

}
