package com.alex.store.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.alex.store.rest.service.user.UserService;

@ApplicationPath("/rest")
public class RestApi extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(UserService.class);
		return set;
	}
	
}
