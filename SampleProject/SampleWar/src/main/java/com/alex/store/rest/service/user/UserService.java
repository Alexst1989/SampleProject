package com.alex.store.rest.service.user;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.alex.store.user.UserInfo;

@Path("userService")
public class UserService {

	@GET
	@Produces("application/json")
	public UserInfo getUserInfo(String userId) {
		UserInfo ui = new UserInfo();
		ui.setAge("18");
		//ui.setName("Kristi");
		return ui;
	}
	
}
