package com.alex.store.rest.service.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alex.store.user.UserInfo;

@RestController
@RequestMapping(path="/userService2")
public class SpringUserService {
	
	@RequestMapping(method=RequestMethod.GET)
	public UserInfo getUserInfo(@PathVariable String userId) {
		UserInfo ui = new UserInfo();
		ui.setAge("18");
		//ui.setName("Kristi");
		return ui;
	}
	

}
